package com.husjay.net.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 客户端
 * 1 创建客户端＋端口
 * 2 准备发送数据
 * 3 封装成包 发送的地点和端口
 * 4 发送数据 double类型转成字节数据
 * 5 释放
 * @author hsj
 *
 */
public class Client {
	public static void main(String[] args) throws IOException {
		//1 创建服务端＋端口
		DatagramSocket client = new DatagramSocket(6666);
		//2 准备发送数据
		double num = 89.12;
		
		byte[] data = convert(num);
		//3 封装成包 发送的地点和端口
		InetSocketAddress serverAddress = new InetSocketAddress("localhost",8888);
		DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress);
		//4 发送数据
		client.send(packet);
		//5 释放
		client.close();
	}
	
	public static byte[] convert(double num) throws IOException {
		byte[] data = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeDouble(num);
		
		//获取数据
		data = bos.toByteArray();
		dos.close();
		return data;
	}
}
