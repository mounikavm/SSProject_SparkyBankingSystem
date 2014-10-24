package com.group10.sparkysbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group10.sparkysbank.model.User;
import com.group10.sparkysbank.dao.UserDao;
import com.group10.sparkysbank.dao.UserDaoImpl;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional
	public void registerUser(User user) {
		
		// TODO Auto-generated method stub
		userDao.registerUser(user);
		
		
	}

}
