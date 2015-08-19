package com.husjay.io.other;
/**
 * 1 System.in
 * 2 System.out
 * 	 System.err
 * 
 * --》重定向
 * setIn()
 * setOut()
 * setErr()
 * FileDescriptor.in
 * FileDescriptor.out
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class PrintStreamDemo01 {
	public static void main(String[] args) throws FileNotFoundException {
		//System.out.println("hhhh");
		//重定向，输出到文件
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("/Users/hsj/test/dest5.txt")), true));
		System.out.println("abc");
		//System.out.flush();
		//重定向，输出到控制台
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)), true));
		System.out.println("abcd");
	}
	/**
	 * 从文件读取
	 * @throws FileNotFoundException
	 */
	public static void test2() throws FileNotFoundException {
		InputStream is = System.in;
		is = new BufferedInputStream(new FileInputStream("/Users/hsj/test/dest5.txt"));
		Scanner sc = new Scanner(is);
		String str = sc.next();
		System.out.println(str);
	}
	/**
	 * PrintStream 打印流－－》处理流
	 * 写入到文件
	 * @author hsj
	 *
	 */
	public static void test1() throws FileNotFoundException {
		PrintStream ps = System.out;
		ps.println(false);
		
		//输出到文件
		File dest = new File("/Users/hsj/test/dest5.txt");
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(dest)));
		ps.println("hhhhh");
		ps.flush();
		ps.close();
	}
}
