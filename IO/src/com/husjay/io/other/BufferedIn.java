package com.husjay.io.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 封装输入
 * @author hsj
 *
 */
public class BufferedIn {
	public static void main(String[] args) throws IOException {
		InputStream is = System.in;
		BufferedReader br = new BufferedReader (new InputStreamReader(is));
		
		String str = br.readLine();
		System.out.println(str);
	}
}
