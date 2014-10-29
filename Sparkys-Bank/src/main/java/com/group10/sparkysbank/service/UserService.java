package com.group10.sparkysbank.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group10.sparkysbank.dao.UserInfoDAO;
import com.group10.sparkysbank.model.Roles;
import com.group10.sparkysbank.model.Useraccounts;
import com.group10.sparkysbank.model.Userinfo;

@Service("userService")
public class UserService {

	@Autowired
	UserInfoDAO userInfoDAO;
	public void addNewExternalUuser(Userinfo userInfo)
	{
		Set<Roles> roles=new LinkedHashSet<Roles>();
		roles.add(new Roles("ROLE_INDIVIDUAL_CUSTOMER"));
		userInfo.setRoleses(roles);
		
		Set<Useraccounts> useraccountses=new LinkedHashSet<Useraccounts>();
		useraccountses.add(new Useraccounts("", userInfo, "", "", null, 500, null, null));
		userInfo.setUseraccountses(useraccountses);
	
		userInfoDAO.registerNewUserAccount(userInfo);
	}
}
