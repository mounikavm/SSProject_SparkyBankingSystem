package com.group10.sparkysbank.dao;

import org.hibernate.SessionFactory;
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

}
