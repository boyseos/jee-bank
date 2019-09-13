package com.bank.web.daos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.MemberBean;

public interface MemberDao {
	public void insertMember(CustomerBean param);
	public void insertEmployee(EmployeeBean param);
	public List<CustomerBean> getCustomerFile();
	public List<EmployeeBean> getEmployeeFile();
	public void reWrite(List<CustomerBean> param);
	public BufferedWriter writer(String file, boolean add) throws Exception;
	public BufferedReader reader(String file) throws Exception;
}
