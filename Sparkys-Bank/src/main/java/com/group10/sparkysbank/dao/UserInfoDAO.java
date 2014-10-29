package com.group10.sparkysbank.dao;

import com.group10.sparkysbank.model.Userinfo;


public interface UserInfoDAO {

	public Userinfo findUserByUsername(String username);
	public void registerNewUserAccount(Userinfo userInfo);
}
