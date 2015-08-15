package com.array;

public class Test02 {
	public static void main(String[] args) {
		//声明
		int[] a;
		int b[];
		//创建数组
		a = new int[4];
		b = new int[5];
		//初始化
		/*
		 * 1 默认初始化，数组元素相当于对象的成员变量，初始化方式与成员变量一样，
		 * 	 数字：0，boolean：false，char：\u0000。
		 */
		/*
		 * 2 动态初始化。即对每个单独赋值。
		 */
		/*
		 * 3 静态初始化
		 */
		int[] c = {23, 23, 28, 32};
		
		Car[] cars = {
						new Car("奔驰"), 
						new Car("宝马"), 
						new Car("比亚迪")
					  } ;
	}
}
