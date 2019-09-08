package com.bank.web.commands;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	public MoveCommand(HttpServletRequest request) throws Exception{
		setRequest(request);
		setAction(request.getParameter("action") != null 
				? request.getParameter("action") : "move");
		execute();
	}
	
	@Override
	public void execute(){
		super.execute();
	}
}
