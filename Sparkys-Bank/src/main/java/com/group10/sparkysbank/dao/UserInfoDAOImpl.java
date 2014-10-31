package com.group10.sparkysbank.dao;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.group10.sparkysbank.model.Pwdrecovery;
import com.group10.sparkysbank.model.Roles;
import com.group10.sparkysbank.model.UserRoles;
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

	public int registerNewUserAccount(Userinfo userInfo, Useraccounts account,Pwdrecovery sec,UserRoles roles) {
		Session session=sessionFactory.getCurrentSession();
	//	session.beginTransaction();
		session.save(userInfo);
		session.save(account);
		session.save(sec);
		session.save(roles);
		Criteria criteria=session.createCriteria(Useraccounts.class);
		criteria.add(Restrictions.eq("username",account.getUsername()));
		Useraccounts acc=(Useraccounts)criteria.uniqueResult();
		return acc.getAccountno();
	}

	public Set<String> getRolesByUserId(String username) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from UserRoles where username=:uname");
		query.setParameter("uname", username);
		ArrayList<UserRoles> list= (ArrayList<UserRoles>) query.list();
		Set<String> role=new LinkedHashSet<String>();
		for(UserRoles roles:list)
		{
			role.add(roles.getRole());
		}
		return role;
	}

}
