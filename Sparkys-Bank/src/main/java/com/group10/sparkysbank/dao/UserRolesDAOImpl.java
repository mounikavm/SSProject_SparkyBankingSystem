package com.group10.sparkysbank.dao;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userRolesDAO")
public class UserRolesDAOImpl implements UserRolesDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public Set<String> getRolesByUserId(int userId) {
	
	/*	Session session=sessionFactory.getCurrentSession();
		//session.beginTransaction();
		
		Query query=session.createQuery("from UserRolesId where iduserinfo=:id");
		query.setParameter("id", userId);
		ArrayList<UserRolesId> userRoles= (ArrayList<UserRolesId>) query.list();
		Set<String> roles=new LinkedHashSet<String>();
		for(UserRolesId userRole:userRoles)
		{
			roles.add(userRole.getRoleType());
		}
		
		return roles;
	*/
		return null;}

}
