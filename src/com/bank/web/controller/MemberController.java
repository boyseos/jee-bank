package com.bank.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.commands.*;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.pool.Constants;
import com.bank.web.serviceimpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

@WebServlet("/customer.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		CustomerBean cm = new CustomerBean();
		EmployeeBean em = null;
		MemberBean mb = new MemberBean();
		MemberService service = new MemberServiceImpl();
		Receiver.init(request);
		
		switch (Receiver.cmd.getAction()) {
		case "login":
			mb.setId(request.getParameter("id"));
			mb.setPass(request.getParameter("pass"));
			if(service.login(mb)) {
				request.setAttribute("customer",service.getLoginMember());
			}else {
				Receiver.cmd.setPage("login");
			}
			break;
		case "join":
			cm.setId(request.getParameter("id"));
			cm.setPass(request.getParameter("pass"));
			cm.setName(request.getParameter("name"));
			cm.setSsn(request.getParameter("ssn"));
			cm.setCredit(request.getParameter("credit"));
			service.join(cm);
			break;
		case "mypage":
			
			break;
		case "loginpage":
			String changePass = request.getParameter("changepass")
			,deleteMember = request.getParameter("deletemember");
			mb.setPass(changePass);
			if(changePass != "") {
				service.updatePass(mb);
			}else if(deleteMember != "") {
				mb.setPass(deleteMember);
				service.deleteMember(mb);
			}
			break;
		}
		Sender.forward(response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
