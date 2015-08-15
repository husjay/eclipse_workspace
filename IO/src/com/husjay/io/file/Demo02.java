package com.husjay.io.file;

import java.io.File;

/**
 * 绝对路径和相对路径
 * @author hsj
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String parentPath = "/Users/hsj/Pictures/Wallpaper";
		String name = "2.jpg";
		//相对路径
		File path = new File(parentPath, name);
		path = new File(new File(parentPath), name);
		System.out.println(path.getPath());
		System.out.println(path.getName());
		
		//绝对路径
		String filePath = "/Users/hsj/Pictures/Wallpaper/2.jpg";
		File path1 = new File(filePath);
		System.out.println(path1.getPath());
		System.out.println(path1.getName());
		System.out.println();
		//当前路径
		File path2 = new File("test.txt");
		System.out.println(path2.getPath());
		System.out.println(path2.getName());
		System.out.println(path2.getAbsolutePath());
	}
}
