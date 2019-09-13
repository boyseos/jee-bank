package com.bank.web.commands;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.domains.MemberBean;
import com.bank.web.serviceimpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

public class UpdateCommand extends MoveCommand{

	public UpdateCommand(HttpServletRequest request) {
		super(request);
		System.out.println("업뎃생성자 진입");
	}
	
	@Override
	public void execute() {
		super.execute();
		MemberBean mb = new MemberBean();
		MemberService service = new MemberServiceImpl();
		String changePass = request.getParameter("changepass");
		if (changePass != "") {
			mb.setPass(changePass);
			service.updatePass(mb);
		}
	}
}
