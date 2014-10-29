package com.group10.sparkysbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.group10.sparkysbank.model.Userinfo;
import com.group10.sparkysbank.service.UserService;
import com.group10.sparkysbank.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	UserValidator userValidator;
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/addExtUser",method=RequestMethod.POST)
	public String submitForm(@ModelAttribute ("extUser") @Validated Userinfo userInfo, BindingResult result, SessionStatus status)
	{
		
		if(result.hasErrors())
		{
			System.out.println("error");
			return "addExternalUserAccount";
		}
		System.out.println(userInfo.getFirstname());
		userService.addNewExternalUuser(userInfo);
		return "";
	}
	
}
