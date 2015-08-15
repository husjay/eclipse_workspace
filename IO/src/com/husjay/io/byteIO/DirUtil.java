package com.husjay.io.byteIO;

import java.io.File;
import java.io.IOException;

public class DirUtil {
	/**
	 * 拷贝文件夹
	 * @param src
	 * @param dest
	 * @throws IOException 
	 */
	public static void copyDir(String srcPath, String destPath) throws IOException {
		File src = new File(srcPath);
		File dest = new File(destPath);
		copyDir(src, dest);	
	}
	
	public static void copyDir(File src, File dest) throws IOException {
		if(src.isDirectory()) {
			dest = new File(dest, src.getName());
		}
		copyDirDetail(src, dest);
	}
	
	public static void copyDirDetail(File src, File dest) throws IOException {
		if(src.isFile()) {
			//文件
			FileUtil.copyFile(src, dest);
		} else if(src.isDirectory()) {
			//文件夹
			dest.mkdirs();
			//获取下一级目录 | 文件
			for(File sub:src.listFiles()) {
				copyDir(sub, new File(dest, sub.getName()));
			}
		}
	}
}
