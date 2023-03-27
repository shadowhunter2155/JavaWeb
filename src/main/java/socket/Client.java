package socket;


import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 5555;
		Socket socket = new Socket(host,port);
		System.out.println("success!");
		socket.close();
	}
}
