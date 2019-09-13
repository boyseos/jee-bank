package com.bank.web.test;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		System.out.println(System.getProperties());
		System.out.printf("%s",FileTest.class.getResource("").getPath());
	}
}
			