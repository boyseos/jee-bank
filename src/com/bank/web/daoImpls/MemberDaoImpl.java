package com.bank.web.daoImpls;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bank.web.daos.MemberDao;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.pool.Constants;

public class MemberDaoImpl implements MemberDao{
	
	@Override
	public void insertMember(CustomerBean param) {
		try {
			BufferedWriter writer = writer("customers0905.txt",true);
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
		try {
			BufferedWriter writer = writer("employees0905.txt",true);
			writer.write(String.format("%s_%s_%s_%s_%s\n"
					,param.getId()
					,param.getPass()
					,param.getName()
					,param.getSsn()
					,param.getSabun()));
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CustomerBean> getCustomerFile() {
		List<CustomerBean> cba = new ArrayList<CustomerBean>();
		try {
			String result = "";
			CustomerBean temp = null;
			BufferedReader reader = reader("customers0905.txt");
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
		return cba;
	}

	@Override
	public List<EmployeeBean> getEmployeeFile() {
		List<EmployeeBean> eba = new ArrayList<EmployeeBean>();
		try {
			String result = "";
			EmployeeBean temp = null;
			BufferedReader reader = reader("employees0905.txt");
			while((result = reader.readLine()) != null) {
				temp = new EmployeeBean();
				 temp.setId(result.split("_")[0]);
				 temp.setPass(result.split("_")[1]);
				 temp.setName(result.split("_")[2]);
				 temp.setSsn(result.split("_")[3]);
				 temp.setSabun(result.split("_")[4]);
				 eba.add(temp);	
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eba;
	}
	
	public void reWrite(List<CustomerBean> param) {
		try {
			BufferedWriter writer = writer("customers0905.txt",false);
			for (CustomerBean temp : param) {
				writer.write(String.format("%s_%s_%s_%s_%s\n"
						, temp.getId()
						, temp.getPass()
						, temp.getName()
						, temp.getSsn()
						, temp.getCredit()));
			}
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BufferedWriter writer(String file, boolean add) throws Exception {
		return new BufferedWriter(
				new FileWriter(new File(Constants
						.SETFILE_PATH + file),add));
	}

	@Override
	public BufferedReader reader(String file) throws Exception {
		return new BufferedReader(
				new FileReader(new File(Constants
						.SETFILE_PATH+file)));
	}
}
