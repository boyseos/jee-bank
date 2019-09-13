package com.bank.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.domains.MemberBean;
import com.bank.web.serviceimpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

public class LoginCommand extends MoveCommand{
		
	public LoginCommand(HttpServletRequest request) {
		super(request);
		System.out.println("로긴생성자 진입");
	}
	
	@Override
	public void execute() {
		System.out.println("로긴익스큐트 진입");
		super.execute();
		MemberBean mb = new MemberBean();
		MemberService service = new MemberServiceImpl();
		mb.setId(request.getParameter("id"));
		mb.setPass(request.getParameter("pass"));
		if(service.login(mb)) {
			request.setAttribute("customer",service.getLoginMember());
		}else {
			Receiver.cmd.setView("login");
		}
	}
}
