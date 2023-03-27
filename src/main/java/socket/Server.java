package socket;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(5555);
		System.out.println("port:" + serverSocket.getLocalPort());
		
		System.out.println("waiting...");
		Socket clientSocket = serverSocket.accept();
		System.out.println("success...");
		
		clientSocket.close();
		serverSocket.close();
	}
}
