package com.husjay.net.tcp.chat03;

import java.io.Closeable;
import java.io.IOException;

/**
 * 
 * @author hsj
 *
 */
public class CloseUtil {
	public static void clossAll(Closeable... io) {
		for(Closeable temp:io) {
			try {
				temp.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
