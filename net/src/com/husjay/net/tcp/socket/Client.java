package com.husjay.net.tcp.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 1 创建客户端 必须指定服务器端＋端口
 * 	socket(String host, int port)
 * 2 接收数据 发送数据
 * @author hsj
 *
 */
public class Client {
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1 创建客户端 必须指定服务器端＋端口
		Socket client = new Socket("localhost", 8888);
		//2 接收数据
		/*
		BufferedReader br = new BufferedReader(
				new InputStreamReader(
						client.getInputStream())
				);
		String echo = br.readLine();
		System.out.println(echo);
		*/
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String msg = dis.readUTF();
		System.out.println(msg);
	}
}
