package com.hushay.thread;
/**
 * 静态代理
 * 1 真是角色
 * 2 代理角色,持有真是角色的引用
 * 3 二者要实现相同的接口
 * @author hsj
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		//创建真是角色
		You you = new You();
		//创建代理角色
		WeddingCompany company = new WeddingCompany(you);
		//执行任务
		company.marry();
		
	}
}

interface Marry{
	public abstract void marry();
}

//真实角色 
class You implements Marry{

	@Override
	public void marry() {
		// TODO Auto-generated method stub
		System.out.println("你和她结婚。。。");
	}
	
}
//代理角色
class WeddingCompany implements Marry {

	private Marry you;
	
	public WeddingCompany(){
		
	}
	public WeddingCompany(Marry you) {
		this.you = you;
	}
	
	public void before(){
		System.out.println("婚前准备");
	}
	public void after(){
		System.out.println("婚后处理");
	}
	@Override
	public void marry() {
		// TODO Auto-generated method stub
		before();
		you.marry();
		after();
	}
	
}