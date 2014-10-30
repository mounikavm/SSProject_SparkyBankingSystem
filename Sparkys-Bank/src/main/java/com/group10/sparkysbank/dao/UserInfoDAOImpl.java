package com.group10.sparkysbank.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group10.sparkysbank.model.Useraccounts;
import com.group10.sparkysbank.model.Userinfo;

@Repository(value="userInfoDAO")
public class UserInfoDAOImpl implements UserInfoDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public Userinfo findUserByUsername(String username) {
		
		Session session=sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Userinfo.class);
		criteria.add(Restrictions.eq("username", username));
		Userinfo user=(Userinfo)criteria.uniqueResult();
		return user;
	}

	public int registerNewUserAccount(Userinfo userInfo, Useraccounts account) {
		Session session=sessionFactory.getCurrentSession();
	//	session.beginTransaction();
		session.save(userInfo);
		session.save(account);
		Criteria criteria=session.createCriteria(Useraccounts.class);
		criteria.add(Restrictions.eq("userinfo",userInfo));
		Useraccounts acc=(Useraccounts)criteria.uniqueResult();
		return acc.getAccountno();
	}

}
