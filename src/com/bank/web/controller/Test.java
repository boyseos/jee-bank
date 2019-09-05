package com.bank.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import com.bank.web.daoImpls.AccountDaoImpl;
import com.bank.web.daos.AccountDao;
import com.bank.web.domains.AccountBean;
import com.bank.web.serviceimpls.AccountServiceImpl;
import com.bank.web.services.AccountService;

public class Test {
	public static void main(String[] args) {
		AccountBean member = null;
		List<AccountBean> aArr;
		AccountService service = new AccountServiceImpl();
		AccountDao serviced = new AccountDaoImpl();
		String result = null;
		while (true) {
			switch (JOptionPane.showInputDialog("0.종료\n"
												+ "1.계좌개설\n"
												+ "2.입금\n"
												+ "3.출금\n"
												+ "4.계좌조회\n"
												+ "5.계좌삭제\n"
												+ "6.총 계좌수\n"
												+ "7.총 계좌확인\n"
												+ "8.파일불러오기\n"
												+ "9.파일저장")) {
			case "0": return;
			case "1":
				service.createAccount(Integer.parseInt(
						JOptionPane.showInputDialog("얼마를 넣으시겠습니까")));
				JOptionPane.showMessageDialog(null, "계좌생성");
				break;
			case "2":
				member = new AccountBean();
				member.setAccountNum(
						JOptionPane.showInputDialog("계좌번호를 넣어주세요"));
				member.setMoney(
						JOptionPane.showInputDialog("얼마를 넣으시겠습니까"));
				service.depositMoney(member);
				JOptionPane.showMessageDialog(null,	service
						.findByAccountNum(member.getAccountNum()).toString());
				break;
			case "3":
				member = new AccountBean();
				member.setAccountNum(JOptionPane
						.showInputDialog("계좌번호를 넣어주세요"));
				member.setMoney(JOptionPane
						.showInputDialog("얼마를 찾으시겠습니까"));
				service.withdrawMoney(member);
				JOptionPane.showMessageDialog(null,	service
						.findByAccountNum(member.getAccountNum()).toString());
				break;
			case "4":
				JOptionPane.showMessageDialog(null, 
						service.findByAccountNum(
								JOptionPane.showInputDialog(
										"계좌번호를 넣어주세요")).toString());
				break;
			case "5":
				service.deleteAccountNum(JOptionPane
						.showInputDialog("계좌번호를 넣어주세요"));
				JOptionPane.showMessageDialog(null, "계좌삭제");
				break;
			case "6":
				JOptionPane.showMessageDialog(null, 
						service.countAccounts()+"계좌");
				break;
			case "7":
				result = "";
				aArr = new ArrayList<AccountBean>(); 
				aArr = service.findAll();
				for(AccountBean temp : aArr) {
					result += temp +"\n";
				}
				JOptionPane.showMessageDialog(null, result);
				break;
			case "8":
				service.loadAll(serviced.getFile());
				break;
			case "9":
				serviced.setFile(service.findAll());
				break;
			}
		}
	}
}
