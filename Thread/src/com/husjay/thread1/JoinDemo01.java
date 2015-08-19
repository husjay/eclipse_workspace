package com.husjay.thread1;
/**
 * 合并线程
 * @author hsj
 *
 */
public class JoinDemo01  extends Thread{

	public static void main(String[] args) throws InterruptedException {
		JoinDemo01 join = new JoinDemo01();
		Thread t = new Thread(join);
		t.start();
		
		for(int i=0; i<100; i++) {
			if(50 == i) {
				t.join();//阻塞main线程
			}
			System.out.println("main..."+i);
		}
	}
	
	@Override
	public void run() {
		for(int i=0; i<200; i++) {
			System.out.println("Join..."+i);
		}
	}
	
}
