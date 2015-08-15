package com.husjay.io.buffered;
/**
 * 字符缓冲流
 * 新增加方法readLine() newLine()
 * 新增方法不能使用多态
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class BufferedCharDemo {
	public static void main(String[] args) {
		//创建源，仅限于纯文本
		File src = new File("/Users/hsj/test/src.txt");
		File dest = new File("/Users/hsj/test/destFile.txt");
		//选择流
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(src));
			writer = new BufferedWriter(new FileWriter(dest));
			/*
			char[] car = new char[1024];
			int len = 0;
			while(-1 != (len = reader.read(car))) {
				writer.write(car, 0, len);
				writer.flush();//强制刷出
			}
			*/
			String line = null;
			while(null != (line = reader.readLine())){
				writer.write(line);
				writer.newLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("源文件不存在");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("流打开失败");
		} finally {
			if(null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(null != writer) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
