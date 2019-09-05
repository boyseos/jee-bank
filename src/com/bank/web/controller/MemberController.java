package com.bank.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.pool.Constants;
import com.bank.web.serviceimpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerBean cm = null;
		EmployeeBean em = null;
		MemberBean mb = null;
		MemberService service = new MemberServiceImpl();
		String dest = "";
		switch (request.getParameter("action")) {
		case "move":
			dest = String.format(Constants.VIEW_PATH,"custommer",request.getParameter("dest"));
			break;
		case "login":
			mb = new MemberBean();
			mb.setId(request.getParameter("id"));
			mb.setPass(request.getParameter("pass"));
			if(service.login(mb)) {
				request.setAttribute("customer",service.findById(mb.getId()));
				dest = String.format(Constants.VIEW_PATH,"custommer","mypage");
			}else {
				System.out.println("로그인 실패");
				dest = String.format(Constants.VIEW_PATH,"custommer","login");
			}
			break;
		case "join":
			cm = new CustomerBean();
			String id = request.getParameter("id");
			String pw = request.getParameter("pass");
			String name = request.getParameter("name");
			String ssn = request.getParameter("ssn");
			String credit = request.getParameter("credit");
			cm.setId(id);
			cm.setPass(pw);
			cm.setName(name);
			cm.setSsn(ssn);
			cm.setCredit(credit);
			service.join(cm);
			dest = String.format(Constants.VIEW_PATH,"custommer","login");
			break;
		case "mypage":
			
			break;
		case "loginpage":
			String changePass = request.getParameter("changepass")
			,deleteMember = request.getParameter("deletemember");
			if(changePass != null) {
				
			}
			if(deleteMember != null) {
				
			}
			service.updatePass(mb);
			break;
		}
		request.getRequestDispatcher(dest).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
