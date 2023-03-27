package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(5555);
		System.out.println("port:" + serverSocket.getLocalPort());
		
		System.out.println("waiting...");
		Socket clientSocket = serverSocket.accept();
		System.out.println("success...");
		
		PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			out.print(inputLine);
			
		}
		
		clientSocket.close();
		serverSocket.close();
	}
}
