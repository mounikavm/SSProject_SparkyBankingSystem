package com.group10.sparkysbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group10.sparkysbank.model.Userinfo;

@Controller
public class HomeController {

	@RequestMapping(value="/intHome")
	public String homePage(ModelMap model)
	{
		return "internalHome";
	}
	
	@RequestMapping(value="/register")
	public String registerAUser(ModelMap model)
	{
		model.addAttribute("extUser", new Userinfo());
		return "addExternalUserAccount";
	}
}
