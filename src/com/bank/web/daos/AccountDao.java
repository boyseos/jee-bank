package com.bank.web.daos;

import java.util.List;
import com.bank.web.domains.AccountBean; 

public interface AccountDao {
	
	public void setFile(List<AccountBean> param);
	public List<AccountBean> getFile();
}
