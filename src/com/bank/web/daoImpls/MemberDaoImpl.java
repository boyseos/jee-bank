package com.bank.web.daoImpls;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.bank.web.daos.MemberDao;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.pool.Constants;

public class MemberDaoImpl implements MemberDao{
	
	@Override
	public void insertMember(CustomerBean param) {
		try {
			BufferedWriter writer = new BufferedWriter(
			new FileWriter(new File(Constants.SETFILE_PATH+"customers0905.txt"),true));
			writer.write(String.format("%s_%s_%s_%s_%s\n"
					,param.getId()
					,param.getPass()
					,param.getName()
					,param.getSsn()
					,param.getCredit()));
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertEmployee(EmployeeBean param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CustomerBean login(CustomerBean param) {
		return null;
	}

	@Override
	public List<CustomerBean> getCustomerFile() {
		List<CustomerBean> cba = new ArrayList<CustomerBean>();
		try {
			String result = "";
			CustomerBean temp = null;
			BufferedReader reader = new BufferedReader(
					new FileReader(new File(Constants
							.SETFILE_PATH+"customers0905.txt")));
			while((result = reader.readLine()) != null) {
				temp = new CustomerBean();
				 temp.setId(result.split("_")[0]);
				 temp.setPass(result.split("_")[1]);
				 temp.setName(result.split("_")[2]);
				 temp.setSsn(result.split("_")[3]);
				 temp.setCredit(result.split("_")[4]);
				 cba.add(temp);
				
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 System.out.println(cba);
		return cba;
	}

	@Override
	public List<EmployeeBean> getEmployeeFile() {
		// TODO Auto-generated method stub
		return null;
	}

}