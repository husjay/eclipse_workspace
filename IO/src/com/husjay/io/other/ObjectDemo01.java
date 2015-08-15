package com.husjay.io.other;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectDemo01 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		seri("/Users/hsj/test/dest4.txt");
		Employee emp = (Employee) read("/Users/hsj/test/dest4.txt");
		System.out.println(emp.getName());
		System.out.println(emp.getSalary());
	}
	
	//序列化
	public static void seri(String destPath) throws IOException {
		Employee emp = new Employee("husjay", 10000);
		int[] arr = {1,2,3,4};
		//创建源
		File dest = new File(destPath);
		//选择流
		ObjectOutputStream dos = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)
						)
				);
		//操作，注意写出的顺序
		dos.writeObject(emp);
		dos.writeObject(arr);
		dos.flush();
		//关闭
		dos.close();
	}
	
	//反序列化
	public static Object read(String srcPath) throws IOException, ClassNotFoundException {
		Object obj = null;
		//创建源
		File src = new File(srcPath);
		//选择流
		ObjectInputStream ios = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(src)
						)
				);
		//操作
		obj = ios.readObject();
		Employee emp = null;
		if(obj instanceof Employee) {
			emp = (Employee)obj;
		}
		obj = ios.readObject();
		int[] arr = (int[])obj;
		System.out.println(Arrays.toString(arr));
		//关闭
		ios.close();
		return emp;
		
	}
}
