package com.bank.web.commands;
import javax.servlet.http.HttpServletRequest;
import com.bank.web.pool.Constants;
import lombok.Data;
@Data
public class Command implements Order  {
	
	protected HttpServletRequest request;
	protected String action, domain, page, view;//프로텍트인데 동일패키지내 겟터셋터처리.
	@Override
	public void execute() {
		setDomain();
		setPage();
	}
	
	public void setDomain() {
		domain = request.getServletPath()
				.replace(".do","").substring(1);
	}
	
	public void setPage() {
		page = request.getParameter("page");
	}
	
	public void setView(String page) {
		view = String.format(Constants.VIEW_PATH,domain,page);
	}
	
//	@Override
//	public void execute() {
//		setDomain();
//		setPage();
//		this.view = String.format(Constants.VIEW_PATH, domain, page);
//	}
}
