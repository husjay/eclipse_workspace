package com.huajsy.io.convert;

import java.io.UnsupportedEncodingException;

public class ConvertDemo01 {
	public static void main(String[] args) {
		//解码byte->char
		String str = "中国";
		//编码char->byte
		byte[] data = str.getBytes();
		System.out.println(new String(data, 0, 3));
	}
	
	public void test1() {
		//解码byte->char
		String str = "中国";
		//编码char->byte
		byte[] data = str.getBytes();
		System.out.println(new String(data));

		try {
			data = str.getBytes("gbk");
			System.out.println(new String(str));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		try {
			//编码
			byte[] data2 = "中国".getBytes("utf-8");
			//解码
			str = new String(data2, "utf-8");
			System.out.println(str);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
