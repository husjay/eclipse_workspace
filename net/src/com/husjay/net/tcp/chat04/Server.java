package com.husjay.net.tcp.chat04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建服务器
 * @author hsj
 *
 */
public class Server {
	private List<MyChannel> all = new ArrayList<MyChannel>();
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		new Server().start();
	}
	
	public void start() throws IOException {
		ServerSocket server = new ServerSocket(9999);
		while(true) {
			Socket client = server.accept();
			MyChannel channel = new MyChannel(client);
			all.add(channel); //加入容器，统一管理
			new Thread(channel).start();
		}
	}
	
	/**
	 * 一个客户端，一条道路
	 * 1 输入流 接收数据
	 * 2 输出流 发送数据
	 * @author hsj
	 *
	 */
	class MyChannel implements Runnable {
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning= true;
		private String name;
		public MyChannel(Socket client) {
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				
				this.name = dis.readUTF();
				
				this.send("欢迎"+this.name+"进入聊天室");
				sendOthers(this.name+"进入聊天室", true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isRunning = false;
				CloseUtil.clossAll(dis, dos);
			}
		}
		/**
		 * 读取数据
		 * @return
		 */
		private String receive() {
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isRunning = false;
				CloseUtil.clossAll(dis);
				all.remove(this); //移除自身
			}
			return msg;
		}
		/**
		 * 发送数据
		 */
		private void send(String msg) {
			if(null == msg || msg.equals("")) {
				return ;
			}
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				isRunning = false;
				CloseUtil.clossAll(dos);
				all.remove(this); //移除自身
			}
		}
		/**
		 * 发送给其他客户端
		 */
		private void sendOthers(String msg, boolean sys) {
			if(msg.startsWith("@") && msg.indexOf(":")>-1) { //私聊
				//获取name
				String name = msg.substring(1, msg.indexOf(":"));
				//获取正文
				String content = msg.substring(msg.indexOf(":")+1);
				for(MyChannel other:all) {
					if(other.name.equals(name)) {
						other.send(this.name+"(私聊)："+content);
					}	
				}
			} else { //群聊
				//遍历容器
				for(MyChannel other:all) {
					if(other == this) {
						continue;
					}
					if(sys) {
						other.send("系统信息"+":"+msg);
					} else {
						//发送给客户端
						other.send(this.name+":"+msg);
					}
				}
			}
		}

		public void run() {
			// TODO Auto-generated method stub
			while(isRunning) {
				sendOthers(receive(), false);
			}
		}
		
	}
}
