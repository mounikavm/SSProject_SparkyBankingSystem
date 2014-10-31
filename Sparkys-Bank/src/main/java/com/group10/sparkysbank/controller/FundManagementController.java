package com.group10.sparkysbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.group10.sparkysbank.model.Transactions;
import com.group10.sparkysbank.service.FundManagementService;
import com.group10.sparkysbank.service.FundManagementServiceImpl;

@Controller
public class FundManagementController {
	
	@Autowired
	private FundManagementService fundManagementService ;
	
	@RequestMapping(value="/transfer",method=RequestMethod.GET)
	public ModelAndView transfer()
	{
		Transactions transactions = new Transactions();
		ModelAndView model = new ModelAndView("Transfer");
		model.addObject("transactions", transactions);
		System.out.println("in transfer controller");	
		return model;
	}
	
	@RequestMapping(value="/transfer", method=RequestMethod.POST)
	public ModelAndView createTransfer(@ModelAttribute("transactions") Transactions transactions, BindingResult result, ModelMap map)
	{
		ModelAndView model;
		try {
			fundManagementService.createTransferTransaction(transactions);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model = new ModelAndView("Transfer");
			e.printStackTrace();
			model.addObject("errorMessage", e.getMessage());
			return model;
		}
		model = new ModelAndView("hello");
		return model;
		
	}
	
	@RequestMapping(value="/credit",method=RequestMethod.GET)
	public ModelAndView credit()
	{
		Transactions transactions = new Transactions();
		ModelAndView model = new ModelAndView("credit");
		model.addObject("credit", transactions);
		System.out.println("in credit controller");
		
		return model;
	}
	
	@RequestMapping(value="/credit", method=RequestMethod.POST)
	public ModelAndView createCredit(@ModelAttribute("credit") Transactions transactions, BindingResult result, ModelMap map)
	{
		ModelAndView model;
		try {
			fundManagementService.createCreditTransaction(transactions);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model = new ModelAndView("credit");
			e.printStackTrace();
			model.addObject("errorMessage", e.getMessage());
			return model;
		}
		model = new ModelAndView("hello");
		return model;
		
	}
	
	@RequestMapping(value="/debit",method=RequestMethod.GET)
	public ModelAndView debit()
	{
		Transactions transactions = new Transactions();
		
		
		ModelAndView model = new ModelAndView("debit");
		model.addObject("debit", transactions);
		System.out.println("in debit controller");
		
		return model;
	}
	
	@RequestMapping(value="/debit", method=RequestMethod.POST)
	public ModelAndView createDebit(@ModelAttribute("debit") Transactions transactions, BindingResult result, ModelMap map)
	{
		ModelAndView model;
		try {
			fundManagementService.createDebitTransaction(transactions);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model = new ModelAndView("debit");
			e.printStackTrace();
			model.addObject("errorMessage", e.getMessage());
			return model;
		}
		model = new ModelAndView("hello");
		return model;
		
	}
}
