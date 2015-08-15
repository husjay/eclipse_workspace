package com.husjay.io.other;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 1 文件－》程序－》字节数组
 * 	1）文件输入流
 * 	2）字节数组输出流
 * 
 * 2 字节数组－》程序－》文件
 * 	1）字节数组输入流
 * 	2）文件输出流
 * @author hsj
 *
 */
public class ByteArrayDemo02 {
	public static void main(String[] args) throws IOException {
		byte[] data = getByteFromFile("/Users/hsj/test/1.jpg");
		System.out.println(new String(data));
		
		toFileFromByteArray(data, "/Users/hsj/test/200.jpg");
	}
	
	public static byte[] getByteFromFile(String srcPath) throws IOException {
		//创建目的地址
		File src = new File(srcPath);
		byte[] dest = null;
		//选择流
		//文件输入流
		InputStream is = new BufferedInputStream (
				new FileInputStream(src)
				);
		//字节数组输出流，不能使用多态
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//操作
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(flush))) {
			//写出到字节数组流中
			bos.write(flush, 0, len);
		}
		bos.flush();
		
		//获取数据
		dest = bos.toByteArray();
		bos.close();
		is.close();
		
		return dest;
	}
	
	public static void toFileFromByteArray(byte[] src, String destPath) throws IOException {
		//创建源
		//目的地
		File dest = new File(destPath);
		//选择流
		//字节数组输入流
		InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));
		//文件输出流
		OutputStream os = new BufferedOutputStream (
				new FileOutputStream(dest)
				);
		//操作
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(flush))) {
			//写出到字节数组流中
			os.write(flush, 0, len);
		}
		os.flush();
		
		//关闭
		is.close();
		os.close();
	}
}	

