package com.bank.web.serviceimpls;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Random;
import com.bank.web.domains.AccountBean;
import com.bank.web.services.AccountService;

public class AccountServiceImpl implements AccountService{
	private List<AccountBean> members;
	
	public AccountServiceImpl() {
		members = new ArrayList<>();
	}
	
	@Override
	public void createAccount(int money) {
		AccountBean member = new AccountBean();
		member.setMoney(String.valueOf(money));
		member.setToday(findDate());
		member.setAccountNum(createAccountNum());
		//while(existAccountNum(member.getAccountNum())){
			
		//}
		members.add(member);
	}

	@Override
	public String createAccountNum() {
		Random ran = new Random();
		return String.format("%04d-%04d", ran.nextInt(9999),ran.nextInt(9999));
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		for(AccountBean temp : members) {
			if(accountNum.equals(temp.getAccountNum())) {
				return temp;
			}
		}
		return null;
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		return findByAccountNum(accountNum) != null;
	}

	@Override
	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm")
				.format(new Date());
	}

	@Override
	public void depositMoney(AccountBean param) {
		AccountBean temp = findByAccountNum(param.getAccountNum());
		temp.setMoney(String.valueOf(
				Integer.parseInt(temp.getMoney()) 
				+ Integer.parseInt(param.getMoney())));
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		AccountBean temp = findByAccountNum(param.getAccountNum());
		temp.setMoney(String.valueOf(
				Integer.parseInt(temp.getMoney()) 
				- Integer.parseInt(param.getMoney())));
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		members.remove(findByAccountNum(accountNum));
	}

	@Override
	public List<AccountBean> findAll() {
		return members;
	}

	@Override
	public void loadAll(List<AccountBean> param) {
		members.addAll(param);	
	}

	@Override
	public int countAccounts() {
		return members.size();
	}

	

}
