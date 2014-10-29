package com.group10.sparkysbank.validator;

import java.util.Date;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.validation.Errors;
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
		String firstname=user.getFirstname();
		String middlename=user.getMiddlename();
		String lastname=user.getLastname();
		String password=user.getPassword();
		Date dob=user.getDob();
		String address=user.getAddress();
		String identificationId=user.getIdentificationid();
		Date expDate=user.getExpirydate();
		
		if(firstname.matches("^[a-z]{1,12}$"))
			
			if(middlename.matches("^[a-z]{1,12}$"))
				if(lastname.matches("^[a-z]{1,12}$"))
					if(password.matches("^[a-z]{1,12}$"))
			
		if(username.matches("/^[a-z0-9_-]{3,16}$/"))
			
	
		System.out.println("in validator");
	}

	
}
