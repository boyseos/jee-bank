package com.bank.web.commands;
import javax.servlet.http.HttpServletRequest;
import com.bank.web.pool.Constants;
import lombok.Data;
@Data
public class Command implements Order  {
	
	protected HttpServletRequest request;
	protected String action, domain, page, view;//프로텍트인데 동일패키지내 겟터셋터처리.
	
	public Command() {
		System.out.println("커맨드 생성자 진입");
	}
	
	@Override
	public void execute() {
		System.out.println("커맨드 익스큐트 진입  " + (request == null ? "리퀘스트널" : "리퀘스트이즈"));
		setPage();
		setDomain();
		setView(page);
	}
	
	public void setPage() {
		page = request.getParameter("page");
	}

	public void setDomain() {
		domain = request.getServletPath().replace(".do","").substring(1);
	}
	
	public void setView(String page) {
		this.page = page;
		view = page.equals("index") ? "index.jsp" : 
			String.format(Constants.VIEW_PATH ,domain , page);
	}
}
