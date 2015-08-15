package com.array;

/*
 * 数组的基本概念
 */
public class Test01 {
	public static void main(String[] args) {
		//创建数组对象，并赋值给数组引用a
		int[] a = new int[3];
		a[0] = 23;
		a[1] = 28;
		a[2] = 32;
		//a[3] = 4;	//数组越界
		
		Car[] cars = new Car[2];
		cars[0] = new Car("奔驰");
		
		System.out.println(a.length);
		for(int i=0; i<a.length; i++)
			System.out.println(a[i]);
	}
}
