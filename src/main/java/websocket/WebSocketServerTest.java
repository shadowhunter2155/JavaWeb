package websocket;

import java.util.concurrent.CopyOnWriteArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocketTest")
public class WebSocketServerTest {
	
	// �ΨӦs�w�s�����Ȥ�� Socket Session ��T
	private static CopyOnWriteArrayList<Session> sessions;
	
	static {
		sessions = new CopyOnWriteArrayList<>();
	}
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("Client �w�s�u ");
		sessions.add(session);
		System.out.println("�ثe�s�u�ƶq: " + sessions.size());
		System.out.println("�ثe�s�u session id: " + session.getId());
	}
	
	@OnMessage
	public void onMessage(String message, Session session) throws Exception {
		System.out.printf("ID: %s message: %s\n", session.getId(), message);
		// �s�����C�@�� client
		sessions.forEach(s -> {
			if(s.isOpen()) {
				s.getAsyncRemote().sendText(message);
			}
		});
	}
	
	@OnClose
	public void onClose(Session session) {
		// �N client �s�u�q sessions ������
		System.out.printf("ID: %s ���}�F\n", session.getId());
		sessions.remove(session);
		System.out.println("�ثe�s�u�ƶq: " + sessions.size());
	}
	
	@OnError
	public void onError(Session session, Throwable throwable) {
		System.out.printf("ID: %s, �����~�o��: %s\n", session.getId(), throwable.getMessage());
	}
	
}