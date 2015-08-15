package com.husjay.io.charIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 纯文本读取
 * @author hsj
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		//创建源
		File src = new File("/Users/hsj/test/src.txt");
		//选择流
		Reader reader =null;
		try {
			reader = new FileReader(src);
			//读取操作
			char[] car = new char[1024];
			int len = 0;
			while(-1 != (len = reader.read(car))) {
				//字符转字符串
				String str = new String(car);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("源文件不存在");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("读取文件失败");
		} finally {
			if(null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("流关闭失败");
				}
			}
		}
	}
}
