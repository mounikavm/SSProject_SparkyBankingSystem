package com.group10.sparkysbank.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		System.out.println("The account no is : "+accno);
		Query query=session.createQuery("from Transactions where fromAccount =:ano");
		query.setParameter("ano", accno);
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

}
