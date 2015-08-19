package com.husjay.syn;
/**
 * 单例的几种创建方式
 * 1 懒汉式
 * 		1 构造器私有化
 * 		2 声明私有的静态属性
 * 		3 对外提供访问属性的静态方法，确保对象存在
 * @author hsj
 *
 */
public class MyJvm {
	private static MyJvm instance = null;
	
	private MyJvm() {
		
	}

	public static MyJvm getInstance() {
		if(null == instance) {
			synchronized (MyJvm.class) {
				if(null == instance) {
					instance = new MyJvm();
				}
			}
		}
		return instance;
	}
}

/**
 * 饿汉式
 * 		1 构造器私有化
 * 		2 声明私有的静态属性，同时创建该对象
 * 		3 对外提供访问属性的静态方法
 * @author hsj
 *
 */
class MyJvm2 {
	private static MyJvm2 instance = new MyJvm2();
	
	private MyJvm2() { 
		
	}

	public static MyJvm2 getInstance() {
		return instance;
	}
}

/**
 * 类再使用时才加载，延缓加载时间
 * @author hsj
 *
 */
class MyJvm3 {
	private static class JVMholder {
		private static MyJvm3 instance = new MyJvm3();
	}
	
	private MyJvm3() { 
		
	}

	public static MyJvm3 getInstance() {
		return JVMholder.instance;
	}
}

