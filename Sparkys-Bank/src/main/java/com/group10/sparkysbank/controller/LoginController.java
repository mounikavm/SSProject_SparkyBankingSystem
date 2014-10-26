package com.group10.sparkysbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(ModelMap model)
	{
		System.out.println("in login controller");
		return "userLogin";
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(Model model)
	{
		return "index";
	}
	
	
}
