package com.group10.sparkysbank.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.group10.sparkysbank.model.Transactions;

@Repository("transactionsDao")
public class TransactionsDaoImpl implements TransactionsDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void createTransferTransaction(Transactions transactions)
			throws Exception {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(transactions);		

	}

	public void createCreditTransaction(Transactions transactions)
			throws Exception {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(transactions);
	}

	public void createDebitTransaction(Transactions transactions)
			throws Exception {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(transactions);

		
	}
	
	public Transactions findTransactionByID(int idtransactions) {
		Session session=sessionFactory.getCurrentSession();
		//session.beginTransaction();
		Criteria criteria=session.createCriteria(Transactions.class);
		criteria.add(Restrictions.eq("idtransactions", idtransactions));
		Transactions trans=(Transactions)criteria.uniqueResult();
		return trans;
	}

	public List<Transactions> findTransactionListByAccountno(int accno) {
		Session session=sessionFactory.getCurrentSession();
		//session.beginTransaction();
		Query query=session.createQuery("from Transactions where fromAccount =:ano and status =:statusno");
		query.setParameter("ano", accno);
		query.setParameter("statusno", 1);
		List transList = query.list(); 		

		return transList;
	}

	public Set<Transactions> findPendingTransactionList(String accountno) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Transactions> findPendingTransactionList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Check if trans type is TR_VIEW and 
	@Transactional
	public Transactions findViewableOrNot(int accno)
	{
		Session session=sessionFactory.getCurrentSession();
		//session.beginTransaction();
		Criteria criteria=session.createCriteria(Transactions.class);
		criteria.add(Restrictions.eq("fromAccount", accno));
		criteria.add(Restrictions.eq("transactionTypes", "TR_VIEW"));
		criteria.add(Restrictions.eq("status", 2));
		criteria.add(Restrictions.eq("approvalNeeded", 1));
		Transactions trans=(Transactions)criteria.uniqueResult();
		if(trans!=null)
		{
			trans.setStatus(3);
			trans=updateTrans(trans);
		}
		return trans;
	}
	
	public Transactions updateTrans(Transactions trans)
	{
		 Session session = sessionFactory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
			 session.update(trans); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		return trans;
	}
	
	@Transactional
	public Transactions findEditableOrNot(int accno)
	{
		Session session=sessionFactory.getCurrentSession();
		//session.beginTransaction();
		Criteria criteria=session.createCriteria(Transactions.class);
		criteria.add(Restrictions.eq("fromAccount", accno));
		//criteria.add(Restrictions.eq("transactionTypes", "TR_EDIT"));
		criteria.add(Restrictions.eq("status", 2));
		criteria.add(Restrictions.eq("approvalNeeded", 1));
		Transactions trans=(Transactions)criteria.uniqueResult();
		if(trans!=null)
		{
			if(!(trans.getTransactionTypes().contains("TR_EDIT")))
				trans=null;
			else
			{
				trans.setStatus(3);
				trans=updateTrans(trans);
			}
		}
		return trans;
	}
	
	@Transactional
	public Transactions findTransViewableOrNot(int accno)
	{
		Session session=sessionFactory.getCurrentSession();
		//session.beginTransaction();
		Criteria criteria=session.createCriteria(Transactions.class);
		criteria.add(Restrictions.eq("fromAccount", accno));
		criteria.add(Restrictions.eq("transactionTypes", "TR_VIEWTR"));
		criteria.add(Restrictions.eq("status", 2));
		criteria.add(Restrictions.eq("approvalNeeded", 1));
		Transactions trans=(Transactions)criteria.uniqueResult();
		if(trans!=null)
		{
			trans.setStatus(3);
			trans=updateTrans(trans);
		}
		return trans;
	}


}
