package net.azib.java.lessons.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * PrimitiveWebServer
 *
 * @author anton
 */
public class PrimitiveWebServer {

	private static final int DEFAULT_PORT = 8080;
	
	public static final String HTTP_LN = "\r\n";
	public static final String HTTP_OK_RESPONSE = "HTTP 200 OK" + HTTP_LN;

	public void handleRequest(InputStream input, OutputStream out) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			if (reader.readLine().startsWith("GET ")) {
					out.write((HTTP_OK_RESPONSE + 
							  "Server: " + getClass().getSimpleName() + HTTP_LN +
							  "Content-Type: text/html" + HTTP_LN +
							  HTTP_LN + 
							  "<h1>Hello World!</h1>").getBytes());
			}
		}
		catch (IOException e) {
			// TODO!!!!
		}
	}
	
	private void closeQuietly(Socket socket) {
		if (socket != null) {
			try {
				socket.close();
			}
			catch (IOException e) {
			}
		}
	}
	
	private class RequestHandler implements Runnable {
		
		private Socket socket;

		public RequestHandler(Socket s) {
			this.socket = s;
		}

		public void run() {
			try {
				handleRequest(socket.getInputStream(), socket.getOutputStream());
			}
			catch (IOException e) {
				System.err.println("Request handling failed");
			}			
			finally {
				closeQuietly(socket);
			}
		}
		
	}
	
	public void run() {
		ServerSocket server;
		try {
			server = new ServerSocket(DEFAULT_PORT);
		}
		catch (IOException e) {
			System.err.println("Unable to bind to port " + DEFAULT_PORT);
			return;
		}
		
		while (true) {
			Socket socket = null;
			try {
				socket = server.accept();
				new Thread(new RequestHandler(socket)).start();
			}
			catch (IOException e) {
			}
		}		
	}
	
	public static void main(String[] args) {
		new PrimitiveWebServer().run();
	}
}







