package com.bank.web.commands;

import javax.servlet.http.HttpServletRequest;

public class Receiver {
	public static Command cmd = null;
	public static void init(HttpServletRequest request) {
		try {
			cmd = new MoveCommand(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
