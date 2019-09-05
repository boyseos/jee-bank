package com.bank.web.domains;

import java.io.Serializable;

public class EmployeeBean extends MemberBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sabun;
	
	public int getSabun() {
		return sabun;
	}
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	
	@Override
	public String toString() {
		return String.format("운영자 sabun = %s\n"
				+ "ID = %s\n"
				+ "PASS = %s\n"
				+ "Name = %s\n"
				+ "ssn = %s\n", sabun, getId(),getPass(),getName(),getSsn());
				
	}
}
