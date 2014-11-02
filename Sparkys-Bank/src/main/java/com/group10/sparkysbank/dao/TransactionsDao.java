package com.group10.sparkysbank.dao;

import java.util.List;
import java.util.Set;

import com.group10.sparkysbank.model.Transactions;

public interface TransactionsDao {

	public void createTransferTransaction(Transactions transactions) throws Exception;

	public void createCreditTransaction(Transactions transactions)throws Exception;

	public void createDebitTransaction(Transactions transactions)throws Exception;
	
	public Transactions findTransactionByID(int idtransactions);
	public List<Transactions> findTransactionListByAccountno(int accountno);
	public Set<Transactions> findPendingTransactionList(String accountno);
	public Set<Transactions> findPendingTransactionList();
}
