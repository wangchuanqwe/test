package com.sc.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Mysessionlistener implements HttpSessionListener {

				public static int count=0;
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
				count++;
				System.out.println("һ���û�������,IP:"+arg0.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
				count--;
				System.out.println("һ���û��˳���");
	}

}
