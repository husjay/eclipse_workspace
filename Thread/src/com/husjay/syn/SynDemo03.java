package com.husjay.syn;

public class SynDemo03 {
	public static void main(String[] args) {
		Object goods = new Object();
		Object money = new Object();
		Test t1 = new Test(goods, money);
		Test2 t2 = new Test2(goods, money);
		Thread p1 = new Thread(t1);
		Thread p2 = new Thread(t2);
		p1.start();
		p2.start();
	}
}

class Test implements Runnable {

	Object goods;
	Object money;
	
	public Test(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}

	@Override
	public void run() {
		while(true) {
			try {
				test();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void test() throws InterruptedException {
		synchronized(goods) {
			Thread.sleep(500);
			
			synchronized(money) {
				//System.out.println("一手给钱");
			}
		}
		System.out.println("一手给钱");
	}	
}

class Test2 implements Runnable {

	Object goods;
	Object money;
	
	
	public Test2(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}

	@Override
	public void run() {
		while(true) {
			try {
				test();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void test() throws InterruptedException {
		synchronized(money) {
			Thread.sleep(100);
			
			synchronized(goods) {
				//System.out.println("一手给钱");
			}
		}
		System.out.println("一手给货");
	}	
}
