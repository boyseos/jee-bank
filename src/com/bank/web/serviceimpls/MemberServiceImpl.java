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
	private static int loginIndex, findIndex;
	
	public MemberServiceImpl() {
		dao = new MemberDaoImpl();
		cMember = dao.getCustomerFile();
		eMember = dao.getEmployeeFile();
	}
	
	@Override
	public void join(CustomerBean param) {
		if(existId(param.getId())) {
			return;
		}
		dao.insertMember(param);
		cMember.add(param);
	}

	@Override
	public void register(EmployeeBean param) {
		if(existId(param.getId())) {
			return;
		}
		dao.insertEmployee(param);
		eMember.add(param);
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
		for(CustomerBean c : cMember) {
			if(id.equals(c.getId())) {
				findIndex = cMember.indexOf(c) + 1;
				return c; // 추후 배울 시스템에선 바로 리턴 때리는것이 안좋을지 모르나. 현재 상황에선 이게 효율적임..
			}
		}
		for(EmployeeBean e : eMember) {
			if(id.equals(e.getId())) {
				findIndex = -eMember.indexOf(e) - 1;
				return e;
			}
		}
		return null;
	}

	@Override
	public boolean login(MemberBean param) {
		boolean result = false;
		MemberBean m = findById(param.getId());
		if(nullCheck(m)) {
			return result;
		}
		if(m.getPass().equals(param.getPass())) {
			loginIndex = findIndex;
			System.out.print(memberKindCheck(loginIndex).getId() +" 로그인");
			result = true;
		}
		return result;
	}

	@Override
	public boolean existId(String id) {
		return findById(id) != null;
	}

	@Override
	public void updatePass(MemberBean param) {
		if (memberKindCheck(loginIndex).getPass()
				.equals(param.getPass().split(",")[0])) {
			memberKindCheck(loginIndex)
			.setPass(param.getPass().split(",")[1]);
			dao.reWrite(cMember);
		}
	}

	@Override
	public boolean deleteMember(MemberBean param) {
		boolean result = false;
		if (!memberKindCheck(loginIndex).getPass()
				.equals(param.getPass())){
			return result;
		}
		if(cMember.remove(memberKindCheck(loginIndex))) {
			result = true;
			dao.reWrite(cMember);
		}else {
			eMember.remove(loginIndex +1);
			result = true;
			//dao.reWrite(eMember);
		}
		loginIndex = 0;
		return result;
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

	public MemberBean getLoginMember() {
		return memberKindCheck(loginIndex);
	}

	@Override
	public boolean nullCheck(MemberBean param) {
		return param == null;
	}
	
	public MemberBean memberKindCheck(int index) {
		return index == 0 ? null :
				index > 0 ? cMember.get(index-1) : eMember.get(index+1);
	}

}
