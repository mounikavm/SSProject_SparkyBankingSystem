package com.group10.sparkysbank.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.group10.sparkysbank.dao.UserDao;
import com.group10.sparkysbank.model.User;
import com.group10.sparkysbank.service.UserService;
import com.group10.sparkysbank.service.UserServiceImpl;

@Controller
public class LoginController {

	@Autowired
	private UserService userService ;
	
	
	@RequestMapping(value="/userLogin", method=RequestMethod.POST)
	public String loginPage(@ModelAttribute("users") User user,BindingResult bindingResult, HttpServletRequest request, ModelMap model)
	{
		//userService= new UserServiceImpl();
		System.out.println("mounika"+user.getUserId());
		userService.registerUser(user);
		return "hello";
	}
	
	@RequestMapping(value="/userLogin", method=RequestMethod.GET)

    public String login(Model model) {
		
		model.addAttribute("users",new User());
		System.out.println("mounika1");

          return "userLogin";

    }

}


