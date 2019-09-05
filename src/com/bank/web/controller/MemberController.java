package com.bank.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.pool.Constants;
import com.bank.web.serviceimpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerBean m = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		String dest = "";
		switch (request.getParameter("action")) {
		case "move":
			dest = String.format(Constants.VIEW_PATH,"custommer",request.getParameter("dest"));
			break;
		case "login":
			m.setId(request.getParameter("id"));
			m.setPass(request.getParameter("pass"));
			if(service.login(m)) {
				request.setAttribute("customer",service.findById(m.getId()));
				dest = String.format(Constants.VIEW_PATH,"custommer","mypage");
			}else {
				System.out.println("로그인 실패");
				dest = String.format(Constants.VIEW_PATH,"custommer","login");
			}
			break;
		case "join":
			String id = request.getParameter("id");
			String pw = request.getParameter("pass");
			String name = request.getParameter("name");
			String ssn = request.getParameter("ssn");
			String credit = request.getParameter("credit");
			m.setId(id);
			m.setPass(pw);
			m.setName(name);
			m.setSsn(ssn);
			m.setCredit(credit);
			service.join(m);
			dest = String.format(Constants.VIEW_PATH,"custommer","login");
			break;
		case "mypage":
			break;
		case "existId":
			break;
		}
		request.getRequestDispatcher(dest).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
