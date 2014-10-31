package com.group10.sparkysbank.dao;

import com.group10.sparkysbank.model.Pwdrecovery;
import com.group10.sparkysbank.model.Useraccounts;
import com.group10.sparkysbank.model.Userinfo;


public interface UserInfoDAO {

	public Userinfo findUserByUsername(String username);
	public int registerNewUserAccount(Userinfo userInfo,Useraccounts account,Pwdrecovery sec);
}
