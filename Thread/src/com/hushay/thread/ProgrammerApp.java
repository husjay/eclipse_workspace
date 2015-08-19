package com.hushay.thread;

public class ProgrammerApp {
	public static void main(String[] args) {
		//1 创建真实角色
		Programmer pro = new Programmer();
		//2 创建代理角色＋真实角色引用
		Thread proxy = new Thread(pro);
		//3 调用start()启动线程
		proxy.start();
		
		for(int i=0; i<1000; i++) {
			System.out.println("一边了聊qq。。。");
		}
	}
}
