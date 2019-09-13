package com.bank.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.domains.CustomerBean;
import com.bank.web.serviceimpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

public class CreateCommand extends MoveCommand{
	public CreateCommand(HttpServletRequest request) {
		super(request);
		System.out.println("크리에이트 생성자 진입");
	}
	@Override
	public void execute() {
		super.execute();
		CustomerBean cm = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		cm.setId(request.getParameter("id"));
		cm.setPass(request.getParameter("pass"));
		cm.setName(request.getParameter("name"));
		cm.setSsn(request.getParameter("ssn"));
		cm.setCredit(request.getParameter("credit"));
		service.join(cm);

	}
//	
}
