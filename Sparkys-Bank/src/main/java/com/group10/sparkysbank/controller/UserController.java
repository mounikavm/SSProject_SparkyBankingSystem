package com.group10.sparkysbank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
	UserService userService;

	@Autowired
	UserValidator userValidator;

	@Autowired
	PasswordEncoder encoder;

	@RequestMapping(value="/addExtUser",method=RequestMethod.POST)
	public String submitForm(ModelMap model, @ModelAttribute ("extUser") @Validated Userinfo userInfo, BindingResult result, SessionStatus status, HttpServletRequest request, HttpServletResponse response)
	{
		String que1=request.getParameter("sec1").toString();
		String que2=request.getParameter("sec2").toString();

		String ans1=request.getParameter("sec1ans").toString();
		String ans2=request.getParameter("sec2ans").toString();
		if(que1.equals(que2))
		{
			model.addAttribute("error", "error");
			result.addError(new ObjectError("", "asda"));
		}

		if(ans1.equals("") || ans1==null || ans2.equals("") || ans2==null)
		{
			model.addAttribute("ans","ans");
			result.addError(new ObjectError("", "asdad"));
		}
		userValidator.validate(userInfo, result);

		if(result.hasErrors())
		{
			System.out.println("error");
			return "addExternalUserAccount";
		}
		System.out.println(userInfo.getFirstname());
		String pass=userInfo.getPassword();
		userInfo.setPassword(encoder.encode(pass));


		int accno=userService.addNewExternalUuser(userInfo,que1,que2,ans1,ans2);

		model.addAttribute("accno", accno);
		return "addExternalUserAccount";
	}

}
