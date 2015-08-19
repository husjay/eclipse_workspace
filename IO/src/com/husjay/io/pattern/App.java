package com.husjay.io.pattern;

public class App {
	public static void main(String[] args) {
		Voice v = new Voice();
		v.say();
		Amplifier a = new Amplifier(v);
		a.say();
	}
}
