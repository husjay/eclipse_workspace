package com.hushay.thread;

public class Tortoise extends Thread {

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("乌龟第"+i+"步");
		}
	}
	
}
