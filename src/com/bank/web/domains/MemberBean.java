package com.bank.web.domains;

import java.io.Serializable;

public class MemberBean extends AccountBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id, pass, name, ssn;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	@Override
	public String toString() {
		return "멤버정보 [id=" + id + ", pass=" + pass + ""
				+ ", name=" + name + ", ssn=" + ssn + "]";
	}
}
