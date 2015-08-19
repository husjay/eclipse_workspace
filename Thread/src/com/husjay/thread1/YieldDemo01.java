package com.husjay.thread1;

public class YieldDemo01 extends Thread{
	public static void main(String[] args) {
		YieldDemo01 yield = new YieldDemo01();
		new Thread(yield).start();
		
		for(int i=0; i<200; i++) {
			if(50 == i) {
				yield();
			}
			System.out.println("main..."+i);
		}
	}

	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("yield..."+i);
		}
	}
	
}
