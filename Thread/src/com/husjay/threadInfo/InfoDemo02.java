package com.husjay.threadInfo;
/**
 * 优先级,代表概率
 * MAX_PRIORITY 10
 * NORM_PRIORITY 5
 * MIN_PRIORITY 1
 * @author hsj
 *
 */
public class InfoDemo02 {
	public static void main(String[] args) throws InterruptedException {
		ThreadInfo t1 = new ThreadInfo();
		Thread p1 = new Thread(t1, "t1");
		ThreadInfo t2 = new ThreadInfo();
		Thread p2 = new Thread(t2, "t2");
		
		p1.setPriority(Thread.MIN_PRIORITY);
		p2.setPriority(Thread.MAX_PRIORITY);
		p1.start();
		p2.start();
		
		Thread.sleep(100);
		
		t1.stop();
		t2.stop();
		System.out.println();
	}
}
