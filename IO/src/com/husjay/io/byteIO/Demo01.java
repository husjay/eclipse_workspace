package com.husjay.io.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 读取文件
     1 建立联系： File对象
     2 选择流： 文件读取流InputStream FileInputStream
     3 操作：byte[] c = new byte[1024] + read + 读取大小
           输出
     4 释放资源：关闭
 * @author hsj
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		//1 建立联系： File对象
		File src = new File("/Users/hsj/test/src.txt");
		//2 选择流： 文件读取流InputStream FileInputStream
		InputStream is = null;
		try {
			is = new FileInputStream(src);
			//3 操作：byte[] c = new byte[1024] + read + 读取大小
			byte[] car = new byte[1024];
			int len = 0;//实际读取大小
			//循环读取
			while(-1 != (len = is.read(car))) {
				//字节数组转成字符串
				String info = new String(car, 0, len);
				System.out.println(info);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("读取文件失败");
		}finally {
			//4 释放资源：关闭
			if(null != is) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("关闭文件流失败");
				}
			}
		}
		
	}
}
