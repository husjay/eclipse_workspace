package com.husjay.pro;

public class App {
	public static void main(String[] args) {
		//共同的资源
		Movie m = new Movie();
		
		//多线程
		Player p = new Player(m);
		Watcher w = new Watcher(m);
		
		new Thread(p).start();
		new Thread(w).start();
	}
}
