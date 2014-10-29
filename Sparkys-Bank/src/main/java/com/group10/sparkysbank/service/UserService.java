package com.group10.sparkysbank.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group10.sparkysbank.dao.UserInfoDAO;
import com.group10.sparkysbank.model.Roles;
import com.group10.sparkysbank.model.Useraccounts;
import com.group10.sparkysbank.model.Userinfo;

@Service("userService")
public class UserService {

	@Autowired
	UserInfoDAO userInfoDAO;
	@Transactional
	public int addNewExternalUuser(Userinfo userInfo)
	{
		Set<Roles> roles=new LinkedHashSet<Roles>();
		roles.add(new Roles("ROLE_INDIVIDUAL_CUSTOMER"));
		userInfo.setRoleses(roles);
		
		Useraccounts account=new Useraccounts();
		account.setBalance(500);
		account.setUserinfo(userInfo);
		
		Set<Useraccounts> accounts=new LinkedHashSet<Useraccounts>();
		accounts.add(account);
		userInfo.setUseraccountses(accounts);
		return userInfoDAO.registerNewUserAccount(userInfo,account);
		
	}
}
