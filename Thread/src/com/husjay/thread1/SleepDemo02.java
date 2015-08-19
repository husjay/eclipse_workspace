package com.husjay.thread1;


/**
 * sleep模拟网络延时
 * @author hsj
 *
 */
public class SleepDemo02 {
	public static void main(String[] args) {
		//真实角色
		Web12306  web = new Web12306();
		//代理
		Thread t1 = new Thread(web, "路人甲");
		Thread t2 = new Thread(web, "黄牛乙");
		Thread t3 = new Thread(web, "工程师");
		//启动线程
		t1.start();
		t2.start();
		t3.start();
	}
}

class Web12306 implements Runnable{
	private int num = 50;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(num<=0) {
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"抢到"+num--);
		}
		
	}
	
}
