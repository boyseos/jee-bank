package com.bank.web.domains;

import java.io.Serializable;

import lombok.Data;
@Data
public class AccountBean extends CustomerBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String accountNum, today, money;
}
