package com.husjay.thread1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 倒计时
 * 1 倒数10个数，1秒钟打印一个
 * 2 倒计时
 * @author hsj
 *
 */
public class SleepDemo01 {
	public static void main(String[] args) throws InterruptedException {
		Date endTime = new Date(System.currentTimeMillis()+10*1000);
		long end = endTime.getTime();
		while(true) {
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			endTime = new Date(endTime.getTime()-1000);
			Thread.sleep(1000);
			if(end-10000 > endTime.getTime()) {
				break;
			}
		}
	}
	
	public void test01() throws InterruptedException {
		int num=10;
		while(true) {
			System.out.println(num--);
			Thread.sleep(1000);
			if(num <= 0) {
				break;
			}
		}
	}
}
