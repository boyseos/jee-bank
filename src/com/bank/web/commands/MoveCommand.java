package com.bank.web.commands;

import javax.servlet.http.HttpServletRequest;

public class MoveCommand extends Command{
	public MoveCommand(HttpServletRequest request){
		System.out.println("무브 생성자 진입");
		this.request = request;
	}
	
	@Override
	public void execute(){
		System.out.println("무브 익스큐트 진입");
		super.execute();
		request.setAttribute("page"
				, getRequest().getParameter("page"));
	}
}
