package com.huajsy.io.convert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流：字节转换字符
 * 1 输出流 OutputStreamWriter 编码
 * 2 输入流 InputStreamReader 解码
 * @author hsj
 *
 */
public class ConvertDemo02 {
	public static void main(String[] args) throws IOException {
		//指定解码格式
		BufferedReader br = new BufferedReader(
			new InputStreamReader(
				new FileInputStream(new File("/Users/hsj/test/Demo.java")), "GBK"
			)
		);
		
		//写出文件
		BufferedWriter bw = new BufferedWriter(
				new FileWriter(new File("/Users/hsj/test/Demo02.java"))
				);
//		BufferedWriter bw = new BufferedWriter(
//			new OutputStreamWriter(
//					new FileOutputStream(new File("/Users/hsj/test/Demo02.java")), "UTF-8"
//					)
//			);
		String info = null;
		while(null != (info = br.readLine())) {
			System.out.println(info);
			bw.write(info);
			bw.newLine();
			bw.flush();
		}
		
		br.close();
	}
}
