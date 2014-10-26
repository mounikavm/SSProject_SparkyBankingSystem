package com.group10.sparkysbank.test;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTester extends TestCase {

	@Test
	public void testPasswordGenerator()
	{
		Md5PasswordEncoder encoder=new Md5PasswordEncoder();
		String password=encoder.encodePassword("secret", null);
		System.out.println(password);
	}
	
}
