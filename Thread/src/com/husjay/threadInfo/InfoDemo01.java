package com.husjay.threadInfo;

public class InfoDemo01 {
	public static void main(String[] args) throws InterruptedException {
		ThreadInfo t1 = new ThreadInfo();
		Thread proxy = new Thread(t1, "t1");
		proxy.setName("test1");
		System.out.println(proxy.getName());
		System.out.println(Thread.currentThread().getName());
		proxy.start();
		System.out.println("启动前状态"+proxy.isAlive());
		Thread.sleep(10);
		t1.stop();
		Thread.sleep(10);
		System.out.println("关闭后状态"+proxy.isAlive());
	}
}
