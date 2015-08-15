package com.husjay.io.byteIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件拷贝
    1 建立联系： File对象
    2 选择流：文件读取流InputStream FileInputStream 
                     文件输出流OutputStream FileOutputStream     
    3 操作：byte[] c = new byte[1024] + read + 读取大小
                  write() + flush()      
    4 释放资源：关闭
 * @author hsj
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		//1 建立联系： File对象
		File src = new File("/Users/hsj/test/1.jpg");
		File dest = new File("/Users/hsj/test/100.jpg");
		//2 选择流：文件读取流InputStream FileInputStream 
        //		  文件输出流OutputStream FileOutputStream 
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dest);
			
			//3 操作：byte[] c = new byte[1024] + read + 读取大小
            //write() + flush()  
			byte[] car = new byte[1024];
			int len = 0;
			while(-1 != (len = is.read(car, 0, car.length))) {
				os.write(car, 0, car.length);
				os.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("输入、输出文件打开失败");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件读取、写出失败");
		} finally {
			if(null != is || null != os) {
				try {
					is.close();
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
