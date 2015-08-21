package com.husjay.net.tcp.chat01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 创建客户端 可以发送数据 接收数据
 * 写出数据：输出流
 * 读入数据：输入流
 * 
 * 输入流与输出流要彼此独立
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
		Socket client = new Socket("localhost", 9999);
		
		//控制台输入
		BufferedReader cansole = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String info = cansole.readLine();
			//输出流
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			dos.writeUTF(info);
			dos.flush();

			//输入流
			DataInputStream dis = new DataInputStream(client.getInputStream());
			String msg = dis.readUTF();
			System.out.println(msg);
		}
	}
}
