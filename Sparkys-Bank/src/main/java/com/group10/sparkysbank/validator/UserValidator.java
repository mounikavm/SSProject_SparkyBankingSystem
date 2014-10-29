package com.group10.sparkysbank.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.group10.sparkysbank.model.Userinfo;


public class UserValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Userinfo.class.isAssignableFrom(arg0);
	}

	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
		Userinfo user=(Userinfo)arg0;
		String username=user.getUsername();
		if(username.matches("/^[a-z0-9_-]{3,16}$/"))
	
		System.out.println("in validator");
	}

	
}
