package com.husjay.pro;
/**
 * 一个场景，共同的资源
 * 生产者消费者模式 信号灯法
 * @author hsj
 *
 */
public class Movie {
	private String pic;
	
	//信号灯
	//flag=true：生产者生产，消费者等待，生产完成后通知消费者
	//flag=false：消费者消费，生产者等待，消费完成后通知生产者
	//wait()等待，会释放锁，而sleep不释放锁
	//notify()通知唤醒
	private boolean flag = true;
	
	public synchronized void play(String pic) throws InterruptedException {
		if(!flag) {//生产者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//开始生产
		Thread.sleep(500);
		
		//生产完成
		this.pic = pic;
		System.out.println("生产"+pic);
		
		//通知消费者
		this.notify();
		
		//生产者停下
		this.flag = false;
	}
	
	public synchronized void watch() throws InterruptedException {
		if(flag) {//消费者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//开始消费
		Thread.sleep(500);
		
		//消费完成
		System.out.println("消费"+pic);
		
		//通知生产者
		this.notify();
		
		//消费者停下
		this.flag = true;
	}
}
