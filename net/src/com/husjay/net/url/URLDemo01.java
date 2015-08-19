package com.husjay.net.url;

import java.net.MalformedURLException;
import java.net.URL;


public class URLDemo01 {
	public static void main(String[] arhs) throws MalformedURLException {
		
		URL url = new URL("http://www.baidu.com:80/index.html#aa?uname:husjay");
		System.out.println("主机："+url.getHost());
		System.out.println("协议："+url.getProtocol());
		System.out.println("端口："+url.getPort());
		System.out.println("文件："+url.getFile());
		System.out.println("相对路径："+url.getPath());
		System.out.println("锚点："+url.getRef());
		System.out.println("参数："+url.getQuery());	//存在锚点则为空
		
		url = new URL("http://www.baidu.com:80/index.html#a/");
		url = new URL(url, "b.txt");
		System.out.println(url.toString());
	}
}
