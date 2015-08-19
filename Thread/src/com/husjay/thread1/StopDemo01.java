package com.husjay.thread1;

public class StopDemo01 {
	public static void main(String[] args) {
		Study s = new Study();
		new Thread(s).start();
		
		//外部干涉
		for(int i=0; i<100; i++) {
			if(i == 50) {
				s.stop();
			}
			System.out.println("main "+i);
		}
	}

}

class Study implements Runnable {
	//1）线程类中定义线程体结束标识
	private boolean flag = true;
	
	@Override
	public void run() {
		//2）线程体中使用标识
		// TODO Auto-generated method stub
		while(flag) {
			System.out.println("study");
		}
	}
	
	public void stop() {
		this.flag = false;
	}
	
}