package com.husjay.io.util;

import java.io.Closeable;
import java.io.IOException;

public class FileUtil {
	/**
	 * 工具类关闭流
	 * 可变参数：...只能在行参的最后一个位置
	 * @throws IOException 
	 */
	public static void close(Closeable ... io) throws IOException {
		for(Closeable temp:io) {
			if(null != temp) {
				temp.close();
			}
		}
	}

}
	