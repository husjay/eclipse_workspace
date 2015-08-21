package com.husjay.net.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 服务器
 * 1 创建服务端＋端口
 * 2 准备接收容器
 * 3 封装成包
 * 4 接收数据
 * 5 分析数据 字节数组转成double类型
 * 6 释放
 * @author hsj
 *
 */
public class Server {
	public static void main(String[] args) throws IOException {
		//1 创建服务端＋端口
		DatagramSocket server = new DatagramSocket(8888);
		//2 准备接收容器
		byte[] container = new byte[1024];
		//3 封装成包 
		DatagramPacket packet = new DatagramPacket(container, container.length);
		//4 接收数据
		server.receive(packet);
		//5 分析数据
		byte[] data = packet.getData();
		double num = convert(data);
		System.out.println(num);
		//6 释放
		server.close();
	}
	
	public static double convert(byte[] data) throws IOException {
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
		double num = dis.readDouble();
		return num;
	}
}
