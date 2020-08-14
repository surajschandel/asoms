package com.lakeacr.asoms;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		String password="asoms";
		String encodedPass=bCryptPasswordEncoder.encode(password);
		System.out.println(encodedPass);
	}

}
