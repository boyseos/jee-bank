package com.bank.web.serviceimpls;

import com.bank.web.domains.EmployeeBean;
import java.util.List;
import java.util.ArrayList;

import com.bank.web.daoImpls.MemberDaoImpl;
import com.bank.web.daos.MemberDao;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.services.MemberService;

public class MemberServiceImpl implements MemberService{

	public MemberDao dao;
	
	public MemberServiceImpl() {
		dao = new MemberDaoImpl();
	}
	
	@Override
	public void join(CustomerBean param) {
		dao.insertMember(param);
	}

	@Override
	public void register(EmployeeBean param) {
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> m = new ArrayList<>();
		int num1 = 0,num2 = 0;
		for(CustomerBean c : dao.getCustomerFile()) {
			if(name.equals(c.getName())) {
				num1++;
			}
		}
		for(EmployeeBean e : dao.getEmployeeFile()) {
			if(name.equals(e.getName())) {
				num2++;
			}
		}
		int num3 = num1+num2; 
		num1 = 0; 
		num2 = 0;
		for(CustomerBean c : dao.getCustomerFile()) {
			if(name.equals(c.getName())) {
				m.add(c);
				num1++;
			}
			if(num1 == num3) return m;
		}
		for(EmployeeBean e : dao.getEmployeeFile()) {
			if(name.equals(e.getName())) {
				m.add(e);
				num2++;
			}
			if(num3 == num1+num2)
				break;
		}
		return m;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean m = new MemberBean();
		for(CustomerBean c : dao.getCustomerFile()) {
			if(id.equals(c.getId())) {
				m = c;
				break;
			}
		}
//		for(EmployeeBean e : dao.getEmployeeFile()) {
//			if(id.equals(e.getId())) {
//				m = e;
//				break;
//			}
//		}
		return m;
	}

	@Override
	public boolean login(MemberBean param) {
		return findById(param.getId()).getPass().equals(param.getPass());
//		boolean flag = false;
//		MemberBean m = new MemberBean();
//		for(CustomerBean c : cMembers) {
//			if(m.equals(c.getId())) {
//				flag = true;
//				break;
//			}
//		}
//		for(EmployeeBean e : dao.getEmployeeFile()) {
//			if(m.equals(e.getId())) {
//				flag = true;
//				break;
//			}
//		}
//		return flag;
	}

	@Override
	public boolean existId(String id) {
		return findById(id) != null;
//		MemberBean m = findById(id);
//		return dao.getEmployeeFile().contains(m) || cMembers.contains(m);
	}

	@Override
	public void updatePass(MemberBean param) {
		MemberBean m = findById(param.getId());
		if(m.getPass().equals(param.getPass().split(",")[0]))
		m.setPass(param.getPass().split(",")[1]);
	}

	@Override
	public boolean deleteMember(MemberBean param) {
		MemberBean m = findById(param.getId());
		return dao.getEmployeeFile().contains(m) ?
				dao.getCustomerFile().remove(m) : dao.getEmployeeFile().remove(m);
	}

	@Override
	public int countCustomers() {
		return dao.getCustomerFile().size();
	}

	@Override
	public int countAdmins() {
		return dao.getEmployeeFile().size();
	}

	@Override
	public List<CustomerBean> findAllCustomers() {
		return dao.getCustomerFile();
	}

	@Override
	public List<EmployeeBean> findAllAdmins() {
		// TODO Auto-generated method stub
		return dao.getEmployeeFile();
	}

	@Override
	public CustomerBean loginD(MemberBean param) {
		// TODO Auto-generated method stub
		return null;
	}

}
