package com.husjay.io.byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 写出文件
    1 建立联系： File对象
    2 选择流： 文件输出流OutputStream FileOutputStream
    3 操作：write() + flush() 
    4 释放资源：关闭
 * @author hsj
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		//1 建立联系： File对象
		File dest = new File("/Users/hsj/test/dest.txt");
		//2 选择流： 文件输出流OutputStream FileOutputStream
		OutputStream os = null;
		try {
			os = new FileOutputStream(dest, true);
			String str = "hushaojie\r\n";
			byte[] data = str.getBytes();
			//字符串转字节数组
			os.write(data, 0, data.length);
			//3 操作：write() + flush() 
			os.flush();//强制刷新出去
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件未找到");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("输出文件失败");
		} finally {
			if(null != os) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("文件关闭失败");
				}
			}
		}
		
	}
}
