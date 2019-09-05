package com.bank.web.services;
import com.bank.web.domains.EmployeeBean;

import java.util.List;

import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.MemberBean;

public interface MemberService {
	public void join(CustomerBean param);
	public void register(EmployeeBean param);
	public List<CustomerBean> findAllCustomers();
	public List<EmployeeBean> findAllAdmins();
	public List<MemberBean> findByName(String name);
	public MemberBean findById(String id);
	public boolean login(MemberBean param);
	public CustomerBean loginD(MemberBean param);
	public int countCustomers();
	public int countAdmins();
	public boolean existId(String id);
	public void updatePass(MemberBean param);
	public boolean deleteMember(MemberBean param);
}