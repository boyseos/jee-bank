package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

public class Movecommand extends Command{
	public Movecommand(HttpServletRequest request) throws Exception{
		setRequest(request);
		setDomain(domain);
		setAction(request.getParameter("action")!=null 
				? request.getParameter("action") : "move");
		execute();
	}
	
	@Override
	public void execute(){
		super.execute();
		request.setAttribute("page", request.getParameter("page"));
	}
}
