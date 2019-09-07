package com.bank.web.pool;

import java.io.File;

public class Constants {
	public static String SETFILE_PATH = "C:"+File.separator+
			"Users"+File.separator+"user"+File.separator+
			"eclipse_jee"+File.separator+"jee-bank"+File.separator+
			"WebContent"+File.separator+"resources"+File.separator+"text"+File.separator;
	final public static String VIEW_PATH = "WEB-INF/views/%s/%s.jsp";
	public Constants() {
		if(new File("e:"+File.separator+
			"study"+File.separator).isDirectory()) {
			SETFILE_PATH = "e:"+File.separator+
					"study"+File.separator+"java"+File.separator+
					"jee-bank"+File.separator+
					"WebContent"+File.separator+"resources"+File.separator+"text"+File.separator;
		}
	}
}
