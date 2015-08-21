package com.husjay.net.tcp.chat03;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 接收数据
 * @author hsj
 *
 */
public class Receive implements Runnable{
	//输入流
	private DataInputStream dis;
	//线程标示
	private boolean isRunning = true;
	public Receive() {
		
	}
	public Receive(Socket client) {
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isRunning = false;
			CloseUtil.clossAll(dis);
		}
	}
	/**
	 * 接收数据
	 */
	public String receive() {
		String msg = "";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	public void run() {
		//线程体
		while(isRunning) {
			System.out.println(receive());
		}
	}

}
