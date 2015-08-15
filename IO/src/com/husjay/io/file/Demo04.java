package com.husjay.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 操作目录
 * mkdir()创建目录，父目录必须存在
 * mkdirs()创建目录，父目录可以不存在
 * list()
 * listRoots()
 * @author hsj
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		String path = "/Users/hsj/test";
		File src = new File(path);
		if(src.isDirectory()) {
			//列出目录中的子目录、文件
			String[] subNames = src.list();
			for(String temp:subNames) {
				System.out.println(temp);
			}
			//列出子目录、文件的引用
			File[] subFiles = src.listFiles();
			for(File temp:subFiles) {
				System.out.println(temp.getAbsolutePath());
			}
			
			//命令设计模式
			subFiles = src.listFiles(new FilenameFilter(){

				@Override
				/**
				 * dir代表src
				 */
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					return new File(dir, name).isFile() && name.endsWith(".txt");
				}
				
			});
			for(File temp:subFiles) {
				System.out.println("=="+temp.getAbsolutePath());
			}
		}
		
	}
	
	public void test() {
		String path = "/Users/hsj/test";
		File src = new File(path);
		src.mkdir();
		src.mkdirs();
	}
}
