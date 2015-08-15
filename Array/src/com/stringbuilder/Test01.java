package com.stringbuilder;
/**
 * String是不可变字符序列
 * StringBuilder是可变字符序列
 * StringBuffer是线程安全的，效率低；而StringBuilder不是线程安全的，效率高，一般用它)
 * @author hsj
 *
 */

public class Test01 {
	public static void main(String[] args) {
		StringBuilder sb1 = new StringBuilder();	//字符数组长度为16
		StringBuilder sb2 = new StringBuilder(32);	//字符数组长度为32
		StringBuilder sb3 = new StringBuilder("hsj");	//字符数组的长度是16+3
		sb3.append(1);
		sb3.append('3');
		sb3.append("111");
		sb3.append(3.24).append("hs").append('j');	//通过return this，实现方法链
		sb3.append(true);
		System.out.println(sb3);
		
		StringBuilder s = new StringBuilder("hsj");	//字符数组大小为16+3
		//当字符数组大小不够时，会自动空大容量(原理是重新创建一个新的字符数组，将引用赋值给它)
		//扩容速度是 size = size*2 + 2
		for(int i=0; i<100; i++)
			s.append(i);
		System.out.println(s);
		
		
	}

}
