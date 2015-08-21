package com.husjay.net.tcp.chat03;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 发送数据
 * @author hsj
 *
 */
public class Send implements Runnable{
	//控制台的输入流
	private BufferedReader cansole;
	//管道输出流
	private DataOutputStream dos;
	//控制线程
	private boolean isRunning = true;
	
	public Send() {
		cansole = new BufferedReader(new InputStreamReader(System.in));
	}
	public Send(Socket client) {
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isRunning = false;
			CloseUtil.clossAll(dos, cansole);
		}
	}
	
	private String getMsgFromCansole() {
		try {
			return cansole.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 从控制台接收数据，然后发送数据
	 */
	public void send() {
		String msg = getMsgFromCansole();
		if(msg != null && !msg.equals("")) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isRunning = false;
				CloseUtil.clossAll(dos, cansole);
			}
		}
	}
	
	public void run() {
		//线程体
		while(isRunning) {
			send();
		}
		
	}

}
