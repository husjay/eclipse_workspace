package com.husjay.threadInfo;

public class ThreadInfo implements Runnable {

	private boolean flag = true;
	private int num = 0;
	
	@Override
	public void run() {
		while(flag) {
			System.out.println(Thread.currentThread().getName()+"-->"+num++);
		}
	}

	public void stop() {
		this.flag = false;
	}
}
