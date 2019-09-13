package com.bank.web.daoImpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import com.bank.web.daos.AccountDao;
import com.bank.web.domains.AccountBean;
import com.bank.web.pool.Constants;

public class AccountDaoImpl implements AccountDao{
	@Override
	public void setFile(List<AccountBean> param) {		
		try {
			File file = new File(Constants.SETFILE_PATH + "list.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			String msg = "";
			for(AccountBean a : param) {
				msg += a.getAccountNum()+"_";
				msg += a.getMoney()+"_";
				msg += a.getToday()+"\n";
			}
			writer.write(msg);
			writer.flush(); // 전송
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<AccountBean> getFile() {
		List<AccountBean> acl = new ArrayList<AccountBean>();
		try {
		String msg ="";
		File file = new File(Constants.SETFILE_PATH + "list.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String[] msgArray = new String[3];
		
		AccountBean ac = new AccountBean();
		while((msg = reader.readLine()) != null) {
			System.out.println(msg);
			msgArray = new String[3];
			msgArray = msg.split("_");
			ac.setAccountNum(msgArray[0]);
			ac.setMoney(msgArray[1]);
			ac.setToday(msgArray[2]);
			System.out.println(ac);
			acl.add(ac);
		}
		reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return acl;
	}

}
