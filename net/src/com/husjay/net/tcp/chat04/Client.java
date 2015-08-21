package com.husjay.net.tcp.chat04;

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
		System.out.println("请输入用户名：");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		if(name.equals("")) {
			return ;
		}
		Socket client = new Socket("localhost", 9999);
		
		new Thread(new Send(client, name)).start();
		new Thread(new Receive(client)).start();
	}
}
