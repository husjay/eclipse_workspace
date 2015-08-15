package com.husjay.io.other;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 基本数据类型字节流
 *  输入流：DataInputStream
    输出流：DataOutputStream
    有新增方法，所以不能使用多态
 * @author hsj
 *
 */
public class DataDemo01 {
	public static void main(String[] args) throws IOException {
		String destPath = "/Users/hsj/test/dest3.txt";
		write(destPath);
		read("/Users/hsj/test/dest3.txt");
	}
	/*
	 * 数据＋类型输出到文件
	 */
	public static void write(String destPath) throws IOException {
		double point = 1.3;
		long num = 100L;
		String str = "字符串";
		
		//创建源
		File dest = new File(destPath);
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)
						)
				);
		//操作，注意写出的顺序
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);
		dos.flush();
		//关闭
		dos.close();
	}
	/**
	 * 从文件中读取数据＋类型
	 * @throws IOException 
	 * java.io.EOFException ：end of file 表示没有读取到文件内容
	 */
	public static void read(String srcPath) throws IOException {
		//创建源
		File src = new File(srcPath);
		//选择源
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(src)
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
