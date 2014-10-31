package com.group10.sparkysbank.dao;

import java.util.Set;

import com.group10.sparkysbank.model.Pwdrecovery;
import com.group10.sparkysbank.model.Roles;
import com.group10.sparkysbank.model.UserRoles;
import com.group10.sparkysbank.model.Useraccounts;
import com.group10.sparkysbank.model.Userinfo;


public interface UserInfoDAO {

	public Userinfo findUserByUsername(String username);
	public int registerNewUserAccount(Userinfo userInfo,Useraccounts account,Pwdrecovery sec,UserRoles roles);
	public Set<String> getRolesByUserId(String username);
}
