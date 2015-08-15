package com.husjay.io.charIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 文件写出
 * @author hsj
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		//创建源
		File dest = new File("/Users/hsj/test/dest1.txt");
		//选择流
		Writer wr = null;
		try {
			wr = new FileWriter(dest);
			//写出
			String msg = "锄禾日当午\n汗滴禾下土\n是知盘中餐\n粒粒皆辛苦\n";
			wr.write(msg);
			
			wr.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("流打开失败");
		} finally {
			if(null != wr) {
				try {
					wr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("流关闭失败");
				}
			}
		}
	}
}
