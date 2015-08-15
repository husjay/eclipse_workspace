package com.husjay.io.file;

import java.io.File;
import java.util.Arrays;

/**
 * 输出子孙的目录、文件名称
 * 1 listFiles()
 * 2 递归
 * @author hsj
 *
 */
public class Demo05 {
	public static void main(String[] args) {
		String path = "/Users/hsj/test";
		File src = new File(path);
		
		//fileName(src);
		
		File[] roots = File.listRoots();
		
		System.out.println(Arrays.toString(roots));
		for(File temp:roots) {
			fileName(temp);
		}

	}
	
	public static void fileName(File src) {
		if(null == src || !src.exists()) {
			return ;
		}
		System.out.println(src.getAbsolutePath());
		if(src.isDirectory()) {
			for(File temp:src.listFiles()) {
				fileName(temp);
			}
		}
	}
}
