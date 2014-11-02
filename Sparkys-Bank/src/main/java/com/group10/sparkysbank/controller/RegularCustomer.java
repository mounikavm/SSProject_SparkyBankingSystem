package com.group10.sparkysbank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegularCustomer {
	
	@RequestMapping("/extCustomerHome")
	public String externalCustomer(Model model,HttpSession session, HttpServletRequest request)
	{
		return "hello";
	}
	@RequestMapping("/hello1")
	public String externalCustomerHome(Model model)
	{
		return "hello";
	}

}
