package com.husjay.io.other;
/**
 * 文件访问RandomAccessFile seek()
 */
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RndDemo01 {
	public static void main(String[] args) throws IOException {
		File src = new File("/Users/hsj/test/src.txt");
		RandomAccessFile rnd = new RandomAccessFile(src, "r");
		//rnd.seek(10);
		
		//定义缓冲区
		byte[] flush = new byte[1024];
		int len = 0;
		while(-1 != (len = rnd.read(flush))) {
			if(len >= 100) {
				System.out.println("读取200");
				break;
			} else {
				System.out.println(new String(flush, 0, len));
			}
		}
		rnd.close();
	}
}
