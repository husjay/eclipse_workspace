package com.hushay.thread;
/**
 * 创建多线程,重写run(){线程体}
 * 使用线程：1创建子类对象 2调用start()方法(调用run方法属于内部调用不是启动线程)
 * @author hsj
 *
 */
public class Rabbit extends Thread {

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("兔子第"+i+"步");
		}
	}
	
}
