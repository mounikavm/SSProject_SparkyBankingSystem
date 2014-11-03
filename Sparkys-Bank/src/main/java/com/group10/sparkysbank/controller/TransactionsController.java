package com.group10.sparkysbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.group10.sparkysbank.service.AccountManagerService;
import com.group10.sparkysbank.service.TransactionsService;
import com.group10.sparkysbank.service.UserService;
import com.group10.sparkysbank.model.Transactions;
import com.group10.sparkysbank.model.Useraccounts;
import com.group10.sparkysbank.model.Userinfo;

@Controller
public class TransactionsController {

	@Autowired
	TransactionsService transactionsService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	AccountManagerService accountManagerService;
	
	//Sravya's Code
	@RequestMapping(value="/viewTransactions")
	public String viewTransactionAmt(ModelMap model)
	{
		model.addAttribute("transAmt", new Transactions());
		return "transactionsPage";
	}
	
	@RequestMapping(value="/viewTransactions",method=RequestMethod.POST)
	public String viewTransactionAmt(@ModelAttribute ("transAmt") Transactions transactions, BindingResult result, SessionStatus status, Model model)
	{
		
		if(result.hasErrors())
		{
			System.out.println("error");
			return "transactionsPage";
		}
		 model.addAttribute("trans", (this.transactionsService.viewTransaction(transactions.getIdtransactions())).getAmtInvolved());
		//System.out.println(userInfo.getFirstname());
		return "transactionsPage";
	}
	
/*	 @RequestMapping(value="/viewTransaction", method=RequestMethod.POST)
	    public ModelAndView viewTransaction(@ModelAttribute("transactions") Transactions transactions, BindingResult result, ModelMap map){
		 ModelAndView  model = new ModelAndView("transactionsPage");
	     model.addObject("trans", (this.transactionsService.viewTransaction(transactions.getIdtransactions())).getAmtInvolved());
	     return model;
	    }*/
	
/*	 @RequestMapping(value="/viewTransaction")
	    public String viewTransaction(Model model){
		 int id=1;
	        model.addAttribute("trans", (this.transactionsService.viewTransaction(id)).getAmtInvolved());
	       // model.addAttribute("amt_involved", this.transactionsService.listPersons());
	        return "transactionsPage";
	    }*/
	
	//ACTIVITY-List of transactions
	@RequestMapping(value="/UserAccountManagementActivity",method=RequestMethod.GET)
	public String activityUserInfo(Model model)
	{
		model.addAttribute("accessInfo", new Userinfo());
		return "usrAccMgmtActivity";
	}
	
	@RequestMapping(value="/UserAccountManagementActivity",method=RequestMethod.POST)
	public String activityUserInfo(@ModelAttribute ("accessInfo")Userinfo userInfo, BindingResult result, SessionStatus status,Model model)
	{
		//add objects to model
				model.addAttribute("accessInfo", userInfo);
				model.addAttribute("usernameerror",null);
				//validate input format
				if(userInfo.getUsername()!=null)
				{
					if(!(userInfo.getUsername()).matches("^[a-z0-9_-]{3,16}$"))
					{
						model.addAttribute("usernameerror","Please enter a valid username");
						return "usrAccMgmtActivity";
					}
					else
					{
						//validate if reasonable request and username exists
						if(userService.getUserInfobyUserName(userInfo.getUsername())==null)
						{
							model.addAttribute("usernameerror","Specified username does not exist");
							return "usrAccMgmtActivity";
						}
						else
						{
							Userinfo ui = userService.getUserInfobyUserName(userInfo.getUsername());
							//check if the user is an external user
							String ur = userService.getUserRoleType(ui.getUsername());
							if(ur.equals("ROLE_CUSTOMER")||ur.equals("ROLE_MERCHANT"))
							{
							     //check if this viewing has been authorized
								if(userService.getViewTransactionAuthorization(ui.getUsername()))
								{
									Useraccounts ua;
									try
									{
								        ua = accountManagerService.getUserAccountForUserName(userInfo.getUsername());
									}
									catch(Exception e)
									{
										return "usrAccMgmtActivity";
									}
									   List<Transactions> trans =  transactionsService.getTransactionsbyAccountNo(ua.getAccountno());
									   model.addAttribute("accessInfo", ui);
									   model.addAttribute("transList", trans);
									   return "usrAccMgmtActivity";
								}
								else
								{
									model.addAttribute("usernameerror","Currently not authorized to view");
									return "usrAccMgmtActivity";
								}
							}
							else
							{
								model.addAttribute("usernameerror", "Not a valid external user");
								return "usrAccMgmtActivity";
							}
						}
					}
				}
				else
				{
					model.addAttribute("usernameerror","Please enter the username");
					return "usrAccMgmtActivity";
				}
					//////////////////////////
		
		/*//case where the verification credentials are posted and activity records are sent
		if(userInfo.getUsername()!=null)
		{
			//Validating info
			Userinfo ui = userService.getUserInfo(userInfo);
			Useraccounts ua;
			if(ui != null)
			{
				try
				{
			        ua = accountManagerService.getUserAccountForUserName(userInfo.getUsername());
				}
				catch(Exception e)
				{
					return "usrAccMgmtActivity";
				}
				List<Transactions> trans =  transactionsService.getTransactionsbyAccountNo(ua.getAccountno());
			   model.addAttribute("accessInfo", ui);
			   model.addAttribute("transList", trans);
			   return "usrAccMgmtActivity";
			}
			
			else
			{
				model.addAttribute("accessInfo", new Userinfo());
				return "usrAccMgmtActivity";
			}
		}
		else
		{
			model.addAttribute("accessInfo", new Userinfo());
			return "usrAccMgmtActivity";
		}*/
	}
}
