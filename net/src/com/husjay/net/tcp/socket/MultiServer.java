package com.husjay.net.tcp.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1 创建服务器 指定端口ServerSocket(int port)
 * 2 接收客户端的连接
 * 3 发送数据和接收数据
 * 接收多个客户端
 * @author hsj
 *
 */
public class MultiServer {
	public static void main(String[] args) throws IOException {
		//1 创建服务器 指定端口ServerSocket(int port)
		ServerSocket server = new ServerSocket(8888);
		//2 接收客户端的连接 阻塞式
		while(true){
			//一个accept，一个客户端
			Socket socket = server.accept();
			System.out.println("一个客户端建立连接");
			//3 发送数据
			String msg = "欢迎使用";
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();
		}
	}
}
