package com.bank.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.command.*;
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
		CustomerBean cm = null;
		EmployeeBean em = null;
		MemberBean mb = null;
		MemberService service = new MemberServiceImpl();
		Receiver.init(request);
		//Receiver.cmd.execute();
//		if(Receiver.cmd.getAction()==null) {
//			Receiver.cmd.setPage();
//		}
		
		switch (Receiver.cmd.getAction()) {
		case "login":
			mb = new MemberBean();
			mb.setId(request.getParameter("id"));
			mb.setPass(request.getParameter("pass"));
			if(service.login(mb)) {
				request.setAttribute("customer",service.findById(mb.getId()));
			}else {
				Receiver.cmd.setView(
						String.format(Constants.VIEW_PATH
								,Receiver.cmd.getDomain()
								,"login"));
			}
			break;
		case "join":
			cm = new CustomerBean();
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
			,deleteMember = request.getParameter("deletemember")
			,id = request.getParameter("id");
			mb = service.findById(id);
			System.out.printf("changePass = %s\n"
					+ "id = %s\n", changePass ,id);
			if(changePass != null) {
				mb.setPass(mb.getPass()+","+changePass);
				service.updatePass(mb);
			}else if(deleteMember != null) {
				
			}
			break;
		}
		Sender.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
