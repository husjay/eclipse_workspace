package com.husjay.io.buffered;
/**
 * 字节拷贝，添加缓冲流
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedByteDemo {
	public static void copyFile(String srcPath, String destPath) throws IOException {
		//1 建立联系： File对象
		copyFile(new File(srcPath), new File(destPath));
		
	}
	public static void copyFile(File srcFile, File destFile) throws IOException {
		
		//2 选择流：文件读取流InputStream FileInputStream 
        //		  文件输出流OutputStream FileOutputStream 
		//加上缓冲流提高性能
		InputStream is = new BufferedInputStream(new FileInputStream(srcFile));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destFile));
		
		//3 操作：byte[] c = new byte[1024] + read + 读取大小
        //write() + flush()  
		byte[] car = new byte[1024];
		int len = 0;
		while(-1 != (len = is.read(car, 0, car.length))) {
			os.write(car, 0, len);
			os.flush();
		}
		
		is.close();
		os.close();
	}
}
