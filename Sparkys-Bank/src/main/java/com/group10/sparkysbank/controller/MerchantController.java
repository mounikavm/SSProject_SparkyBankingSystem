package com.group10.sparkysbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MerchantController {

	@RequestMapping("/extHome")
	public String submitPayment(Model model)
	{
		return "SubmitPayment";
	}
}
