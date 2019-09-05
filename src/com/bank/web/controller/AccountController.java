package com.bank.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.domains.AccountBean;
import com.bank.web.services.AccountService;
import com.bank.web.serviceimpls.AccountServiceImpl;

@WebServlet("/account.do")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		AccountBean member = null;
		List<AccountBean> members = null;
		AccountService service = new AccountServiceImpl();
		String result = null;
		
		String money = request.getParameter("money");
		System.out.printf("도착%s\n", money);
		//service.createAccount(Integer.parseInt(money));
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/account/join.jsp");
		rd.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
