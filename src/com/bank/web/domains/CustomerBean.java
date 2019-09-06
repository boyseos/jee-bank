package com.bank.web.domains;

import java.io.Serializable;
import com.bank.web.domains.MemberBean;

import lombok.Data;
@Data
public class CustomerBean extends MemberBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String credit;
}
