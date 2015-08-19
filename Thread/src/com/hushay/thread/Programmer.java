package com.hushay.thread;
/**
 * 使用runnable创建线程
 * 1 类实现runnable接口
 * 2 重写run方法
 * 3 启动多线程，使用静态代理
 * 	1 创建真实角色
 * 	2 创建代理角色＋真实角色引用
 * 	3 调用start()启动线程
 * @author hsj
 *
 */
public class Programmer implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<1000; i++) {
			System.out.println("编写代码"+i);
		}
	}
	
}
