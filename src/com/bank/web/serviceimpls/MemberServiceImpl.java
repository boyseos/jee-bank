package com.bank.web.serviceimpls;

import com.bank.web.domains.EmployeeBean;
import java.util.List;
import java.util.ArrayList;

import com.bank.web.daoImpls.MemberDaoImpl;
import com.bank.web.daos.MemberDao;
import com.bank.web.domains.AccountBean;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.services.MemberService;

public class MemberServiceImpl implements MemberService{

	public MemberDao dao;
	private List<CustomerBean> cMember;
	private List<EmployeeBean> eMember;
	
	public MemberServiceImpl() {
		dao = new MemberDaoImpl();
		cMember = dao.getCustomerFile();
		eMember = dao.getEmployeeFile();
	}
	
	@Override
	public void join(CustomerBean param) {
		dao.insertMember(param);
		cMember = dao.getCustomerFile();
	}

	@Override
	public void register(EmployeeBean param) {
		dao.insertEmployee(param);
		eMember = dao.getEmployeeFile();
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> m = new ArrayList<>();
		int num1 = 0,num2 = 0;
		for(CustomerBean c : cMember) {
			if(name.equals(c.getName())) {
				num1++;
			}
		}
		for(EmployeeBean e : eMember) {
			if(name.equals(e.getName())) {
				num2++;
			}
		}
		int num3 = num1+num2; 
		num1 = 0; 
		num2 = 0;
		for(CustomerBean c : cMember) {
			if(name.equals(c.getName())) {
				m.add(c);
				num1++;
			}
			if(num1 == num3) return m;
		}
		for(EmployeeBean e : eMember) {
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
		for(CustomerBean c : cMember) {
			if(id.equals(c.getId())) {
				m = c;
				break;
			}
		}
		for(EmployeeBean e : eMember) {
			if(id.equals(e.getId())) {
				m = e;
				break;
			}
		}
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
		if (m.getPass().equals(param.getPass().split(",")[0])) {
			m.setPass(param.getPass().split(",")[1]);
			dao.reWrite(cMember);
			System.out.println("안오냐?");
		}
	}

	@Override
	public boolean deleteMember(MemberBean param) {
		MemberBean m = findById(param.getId());
		return eMember.contains(m) ?
				eMember.remove(m) : cMember.remove(m);
	}

	@Override
	public int countCustomers() {
		return cMember.size();
	}

	@Override
	public int countAdmins() {
		return eMember.size();
	}

	@Override
	public List<CustomerBean> findAllCustomers() {
		return cMember;
	}

	@Override
	public List<EmployeeBean> findAllAdmins() {
		// TODO Auto-generated method stub
		return eMember;
	}

	@Override
	public CustomerBean loginD(MemberBean param) {
		// TODO Auto-generated method stub
		return null;
	}

}
