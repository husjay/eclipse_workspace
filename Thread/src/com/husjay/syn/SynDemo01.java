package com.husjay.syn;


public class SynDemo01 {
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
	private int num = 10;
	private boolean flag = true;
	
	@Override
	public void run() {
		while(flag){
			test4();
		}
	}
	
	//线程安全，同步方法
	public synchronized void test2() {
		if(num<=0) {
			flag = false;
			return ;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"抢到"+num--);
		
	}
	//线程安全，同步块
	public void test3() {
		synchronized(this){
			if(num<=0) {
				flag = false;
				return ;
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
		
	//锁定信息不完全
	public void test4() {
		//引用类型
		synchronized((Integer)num){
			if(num<=0) {
				flag = false;
				return ;
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
	//线程不安全
	public void test1() {
		if(num<=0) {
			flag = false;
			return ;
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
