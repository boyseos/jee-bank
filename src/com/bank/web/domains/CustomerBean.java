package com.bank.web.domains;

import java.io.Serializable;

public class CustomerBean extends MemberBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String credit;
	
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	@Override
	public String toString() {
		return String.format("고객정보 credit = %s\n"
				+ "ID = %s\n"
				+ "PASS = %s\n"
				+ "Name = %s\n"
				+ "ssn = %s\n", credit, getId(),getPass(),getName(),getSsn());
				
	}
}
