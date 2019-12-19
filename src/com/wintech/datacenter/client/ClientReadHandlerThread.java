package com.wintech.datacenter.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReadHandlerThread implements Runnable {
	private Socket client;
	public static String str;

	public ClientReadHandlerThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		BufferedReader in = null;
		System.out.println("Client reader started.");
		char[] readBuf = new char[1024];
		int charLen = 0;
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while ((charLen = in.read(readBuf)) > 0) {
				str = new String(readBuf).substring(0, charLen);
				System.out.println("<-: " + str);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
					in = null;
				}
				if (client != null) {
					client = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
