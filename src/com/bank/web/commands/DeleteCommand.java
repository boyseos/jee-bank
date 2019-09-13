package com.bank.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.domains.MemberBean;
import com.bank.web.serviceimpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

public class DeleteCommand extends MoveCommand{
	public DeleteCommand(HttpServletRequest request) {
		super(request);
		System.out.println("삭제생성자 진입");
	}
	
	@Override
	public void execute() {
		super.execute();
		MemberBean mb = new MemberBean();
		MemberService service = new MemberServiceImpl();
		String deleteMember = request.getParameter("deletemember");
		if (deleteMember != "") {
			mb.setPass(deleteMember);
			service.deleteMember(mb);
		}
	}
}
