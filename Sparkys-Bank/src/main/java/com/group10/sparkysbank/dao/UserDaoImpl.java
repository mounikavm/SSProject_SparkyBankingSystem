package com.group10.sparkysbank.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group10.sparkysbank.model.Userinfo;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	/*public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
*/

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Transactional
	public void registerUser(Userinfo user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		//session.beginTransaction();
		session.save(user);
	}


	
}
