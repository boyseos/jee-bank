package com.bank.web.commands;

import javax.servlet.http.HttpServletRequest;

public class Commander {
	public static Command order(HttpServletRequest request) {
		System.out.println("커맨더 진입");
		Command cmd = null;
		
		switch (request.getParameter("action") != null 
				? request.getParameter("action") : "move") {
		case "login":
			cmd = new LoginCommand(request);
			break;
		case "join":
			cmd = new CreateCommand(request);
			break;
		case "delete":
			cmd = new DeleteCommand(request);
			break;
		case "update":
			cmd = new UpdateCommand(request);
			break;
		default:
			cmd = new MoveCommand(request);
			break;
		}
		return cmd;
	}
}
