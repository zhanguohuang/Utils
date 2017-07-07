package org.zhan.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

	public static void main(String args[]) {
		
		int port;
		ServerSocket serverSocket;

		try {
			port = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("port = 80 (端口)");
			port = 80; // 默认监听80端口
		}

		try {
			serverSocket = new ServerSocket(port);

			while (true) { //
				try {
					//
					final Socket socket = serverSocket.accept();
					System.out.println("" + socket.getInetAddress() + ":" + socket.getPort());

					service(socket); //
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // #while
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** HTTP */
	public static void service(Socket socket) throws Exception {
		InputStream socketIn = socket.getInputStream(); //
		Thread.sleep(1000); //
		int size = socketIn.available();
		byte[] requestBuffer = new byte[size];
		socketIn.read(requestBuffer);
		String request = new String(requestBuffer);
		System.out.println(request); //
		OutputStream ops = socket.getOutputStream();
		String responseBuffer = "SUCCESS";
		String response = "HTTP/1.1 200 OK\r\n" 
						+ "Content-Type: text/html\r\n" 
						+ "Content-Length: " + responseBuffer.length() + "\r\n" 
						+ "\r\n" 
						+ responseBuffer;
		ops.write(response.getBytes("UTF-8"));
		ops.flush();
		ops.close();
	}
}
