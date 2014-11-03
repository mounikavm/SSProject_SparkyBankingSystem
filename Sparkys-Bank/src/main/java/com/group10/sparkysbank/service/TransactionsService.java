package com.group10.sparkysbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group10.sparkysbank.dao.TransactionsDao;
import com.group10.sparkysbank.model.Transactions;

@Service("transactionsService ")
public class TransactionsService {
	
	@Autowired
	TransactionsDao transactionsDAO;

	@Transactional
	public Transactions viewTransaction(int transid)
	{
		return this.transactionsDAO.findTransactionByID(transid);
	}
	
	@Transactional
	public List<Transactions> getTransactionsbyAccountNo(int accountno)
	{
		return this.transactionsDAO.findTransactionListByAccountno(accountno);
	}
}
