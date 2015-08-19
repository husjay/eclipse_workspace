package com.hushay.thread;
/**
 * 一共有5条线程：Rabbit、Tortoise、main、gc、异常
 * @author hsj
 *
 */
public class RabbitApp {
	
	public static void main(String[] args) {
		Rabbit rab = new Rabbit();
		Tortoise tor = new Tortoise();
		
		rab.start();
		tor.start();
		
		for(int i=0; i<10; i++) {
			System.out.println("main"+i);
		}
	}
}
