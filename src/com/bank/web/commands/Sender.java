package com.bank.web.commands;

import javax.servlet.http.HttpServletResponse;

public class Sender {
	public static void forward(HttpServletResponse response) {
		try {
			System.out.println(Receiver.cmd.getPage()+"\n" + Receiver.cmd.getView());
			Receiver.cmd.getRequest()
			.getRequestDispatcher(Receiver.cmd.getView())
			.forward(Receiver.cmd.getRequest(), response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}