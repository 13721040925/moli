package com.wintech.datacenter.client;

import java.net.Socket;

public class SocketNettyClientTest {
	public static final String IP = "127.0.0.1";// 服务器地址
	public static final int PORT = 8899;// 服务器端口号

	public static void main(String[] args) {
		handler();
	}

	private static void handler() {
		try {
			Socket client = new Socket(IP, PORT);
			new Thread(new ClientReadHandlerThread(client)).start();
			new Thread(new ClientWriteHandlerThread(client)).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
