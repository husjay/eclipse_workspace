package com.husjay.io.other;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class DataDemo02 {
	public static void main(String[] args) throws IOException {
		byte[] data = write();
		System.out.println(data.length);
		read(data);
	}
	/*
	 * 数据＋类型输出到字节数组中
	 */
	public static byte[] write() throws IOException {
		//目标数组
		byte[] dest = null;
		double point = 1.3;
		long num = 100L;
		String str = "字符串";
		
		//创建流
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						bos
						)
				);
		//操作，注意写出的顺序
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		dos.flush();
		//关闭
		bos.close();
		dos.close();
		
		dest = bos.toByteArray();
		return dest;
	}
	/**
	 * 从字节数组中读取数据＋类型
	 * @throws IOException 
	 * java.io.EOFException ：end of file 表示没有读取到文件内容
	 */
	public static void read(byte[] src) throws IOException {
		//创建源
		
		//选择源
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
						new ByteArrayInputStream(src)
						)
				);
		//操作
		double point = dis.readDouble();
		long num = dis.readLong();
		String str = dis.readUTF();
		System.out.println(point);
		System.out.println(num);
		System.out.println(str);
		//关闭
		dis.close();
	}
}
