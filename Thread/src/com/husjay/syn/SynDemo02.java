package com.husjay.syn;
/**
 * 单例设计模式，确保一个类只有一个对象
 * 	类对象由自己内部创建，外部只能使用这一个对象
 * @author hsj
 *
 */
public class SynDemo02 {

	public static void main(String[] args) {
		JvmThread thread1 = new JvmThread(100);
		JvmThread thread2 = new JvmThread(500);
		thread1.start();
		thread2.start();
	}
}

class JvmThread extends Thread {
	private long time;

	public JvmThread() {
		
	}
	public JvmThread(long time) {
		this.time = time;
	}
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()+"创建－－>"+Jvm.getInstance(time));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

/**
 * 单例设计模式
 * 确保一个类只有一个对象
 * 懒汉式
 * 1 构造器私有化
 * 2 声明一个私有的静态变量
 * 3 创建一个对外的公共的静态方法访问该变量，如果变量没有对象，创建该对象
 * @author hsj
 *
 */
class Jvm {
	//1 声明一个私有的静态变量
	private static Jvm instance = null;
	
	//2 构造器私有化，避免外部创建对象
	private Jvm() {
		
	}
	
	//3 创建一个对外的公共的静态方法访问该变量，如果变量没有对象，创建该对象
	public static Jvm getInstance1(long time) throws InterruptedException {
		if(null == instance) {
			Thread.sleep(time);//延时，放大错误
			instance = new Jvm();
		}
		return instance;
	}
	
	public static synchronized Jvm getInstance2(long time) throws InterruptedException {
		if(null == instance) {
			Thread.sleep(time);//延时，放大错误
			instance = new Jvm();
		}
		return instance;
	}
	
	public static  Jvm getInstance3(long time) throws InterruptedException {
		//效率不高，存在对象也需要等待
		synchronized(Jvm.class){
			if(null == instance) {
				Thread.sleep(time);//延时，放大错误
				instance = new Jvm();
			}
			return instance;
		}
	}
	public static  Jvm getInstance(long time) throws InterruptedException {
		//效率高，存在对象不需要等待
		if(null == instance){
			synchronized(Jvm.class){
				if(null == instance) {
					Thread.sleep(time);//延时，放大错误
					instance = new Jvm();
				}
				return instance;
			}
		}
		return instance;
	}
}