package com.husjay.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo01 {
	public static void main(String[] args) throws UnknownHostException{		
		//
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());  //192.168.1.100
		System.out.println(addr.getHostName());  //
		//¸ù¾ÝÓòÃûµÃµ½InetAddress¶ÔÏó
		addr = InetAddress.getByName("www.163.com"); 
		System.out.println(addr.getHostAddress());  //163 IP:61.135.253.15
		System.out.println(addr.getHostName());  //www.163.com	
		//¸ù¾ÝipµÃµ½InetAddress¶ÔÏó
		addr = InetAddress.getByName("14.215.231.174"); 
		System.out.println(addr.getHostAddress());  //61.135.253.15
		System.out.println(addr.getHostName());  //返回ip地址
	}
}
