package com.bank.web.daos;

import java.util.List;

import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.MemberBean;

public interface MemberDao {
	public void insertMember(CustomerBean param);
	public void insertEmployee(EmployeeBean param);
	public CustomerBean login(CustomerBean param);
	public List<CustomerBean> getCustomerFile();
	public List<EmployeeBean> getEmployeeFile();
	public void reWrite(List<CustomerBean> param);
}
