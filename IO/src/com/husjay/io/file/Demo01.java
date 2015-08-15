package com.husjay.io.file;

import java.io.File;

/**
 * 两个常量
 * 	1.路径分隔符
 * 	2.文件分隔符
 * @author hsj
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		
		String path = "/Users/hsj/Pictures/Wallpaper/1.jpg";
		path = File.separator+"Users"+File.separator+"hsj"+File.separator+"Pictures"+File.separator+"Wallpaper"+File.separator+"1.jpg";
		//推荐方式
		path = "/Users/hsj/Pictures/Wallpaper/1.jpg";
	}
}
