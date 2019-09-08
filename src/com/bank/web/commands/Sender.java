package com.bank.web.commands;

import javax.servlet.http.HttpServletResponse;

public class Sender {
	public static void forward(HttpServletResponse response) {
		try {
			Receiver.cmd.setView(Receiver.cmd.getPage());
			Receiver.cmd.request.setAttribute("page", Receiver.cmd.getPage());
			Receiver.cmd.request.getRequestDispatcher(Receiver.cmd.getView())
			.forward(Receiver.cmd.request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
//	public static void  forward(HttpServletRequest request,
//	          HttpServletResponse  response){
//	      System.out.println("캐리어내부 :  "+Receiver.cmd.getView());
//	      try {
//	         request.getRequestDispatcher(Receiver.cmd.getView())
//	                .forward(request,  response);
//	      } catch (Exception e) {
//	          e.printStackTrace();
//	      }
//	   }
}
