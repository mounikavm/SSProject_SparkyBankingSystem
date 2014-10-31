
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
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String home(Model model)
	{
		return "home";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(ModelMap model)
	{
		return "userLogin";
	}
	
	@RequestMapping(value="/loginFailed", method=RequestMethod.GET)
	public String loginFailed(ModelMap model)
	{
		model.addAttribute("error", "true");
		return "userLogin";
	}
	
	@RequestMapping(value="/403", method=RequestMethod.GET)
	public String ifNotAuthorized(ModelMap model)
	{
		return "403";
	}
	
	@RequestMapping(value="/forgotpassword",method=RequestMethod.GET)
	public String forgotPasswordClicked(Model model)
	{
		return "forgotPassword";
	}
}