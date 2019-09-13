package com.bank.web.commands;

import javax.servlet.http.HttpServletRequest;

public class Receiver {
	public static Command cmd = null;
	public static void init(HttpServletRequest request) {
		System.out.println("리시버 진입");
		try {
			cmd = Commander.order(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
