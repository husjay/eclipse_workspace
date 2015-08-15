package com.husjay.io.file;

import java.io.File;
import java.io.IOException;

/**
 * 常用方法
 * @author hsj
 *
 */
public class Demo03 {
	public static void main(String[] args) throws InterruptedException {
		String path = "/Users/hsj/Pictures/Wallpaper/1.jpg";
		File file = new File(path);
		
		try {
			test3();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void test0(File file) {
		//文件名
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getParent());
	}
	public void test1(File file) {
		//判断信息
		System.out.println(file.exists());
		System.out.println(file.canRead());
		System.out.println(file.canWrite());
		System.out.println(file.canExecute());
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		System.out.println(file.isAbsolute());
	}
	public void test2(File file) {
		//长度
		System.out.println(file.length());
		System.out.println(file.getParent().length());
	}
	public static void test3() throws IOException, InterruptedException {
		//创建和删除
		String path = "/Users/hsj/Pictures/Wallpaper/100.jpg";
		File file = new File(path);
		if(!file.exists()) {
			boolean flag = file.createNewFile();//不文件存在时创建，存在时返回false
		}
		
		boolean flag1 = file.delete();
		
		//创建临时文件
		File tempFile = File.createTempFile("hsj",".temp", new File("/Users/hsj/Pictures/Wallpaper"));
		Thread.sleep(3000);
		tempFile.deleteOnExit();
	}
}
