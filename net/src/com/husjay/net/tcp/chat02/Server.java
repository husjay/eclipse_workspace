package com.husjay.net.tcp.chat02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器
 * @author hsj
 *
 */
public class Server {
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9999);
		while(true) {
			Socket socket = server.accept();

			//输入流
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			while(true) {
				String msg = dis.readUTF();

				//输出流
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				dos.writeUTF("服务器"+msg);
				dos.flush();
			}
		}
	}
}
