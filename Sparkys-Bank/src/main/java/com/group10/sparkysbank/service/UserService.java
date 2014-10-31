package com.group10.sparkysbank.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group10.sparkysbank.dao.UserInfoDAO;
import com.group10.sparkysbank.model.Pwdrecovery;
import com.group10.sparkysbank.model.Roles;
import com.group10.sparkysbank.model.Useraccounts;
import com.group10.sparkysbank.model.Userinfo;

@Service("userService")
public class UserService {

	@Autowired
	UserInfoDAO userInfoDAO;
	@Transactional
	public int addNewExternalUuser(Userinfo userInfo,String que1,String que2,String ans1,String ans2)
	{
		Set<Roles> roles=new LinkedHashSet<Roles>();
		roles.add(new Roles("ROLE_INDIVIDUAL_CUSTOMER"));
		userInfo.setRoleses(roles);
		
		Useraccounts account=new Useraccounts();
		account.setBalance(500.0);
		account.setUserinfo(userInfo);
		
		Set<Pwdrecovery> q=new LinkedHashSet<Pwdrecovery>();
		Pwdrecovery p=new Pwdrecovery();
		p.setAns1(ans1);
		p.setAns2(ans2);
		p.setQuestion1(que1);
		p.setQuestion2(que2);
		p.setUserinfo(userInfo);
		q.add(p);
		
		Set<Useraccounts> accounts=new LinkedHashSet<Useraccounts>();
		accounts.add(account);
		
		userInfo.setUseraccountses(accounts);
		userInfo.setPwdrecoveries(q);
		return userInfoDAO.registerNewUserAccount(userInfo,account,p);
		
	}
}
