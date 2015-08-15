package com.husjay.io.byteIO;

import java.io.File;
import java.io.IOException;

/**
 * 文件夹的拷贝
 * 1 递归查找子孙文件 | 文件夹
   2 文件－拷贝
     文件夹－创建
 * @author hsj
 *
 */
public class CopyDir {
	public static void main(String[] args) throws IOException{
		String srcPath = "/Users/hsj/test/src";
		String destPath = "/Users/hsj/test/dest";
		
		DirUtil.copyDir(srcPath, destPath);	
	}
	
	
}
