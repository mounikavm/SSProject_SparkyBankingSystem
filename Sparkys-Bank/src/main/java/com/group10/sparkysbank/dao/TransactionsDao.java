package com.group10.sparkysbank.dao;

import com.group10.sparkysbank.model.Transactions;

public interface TransactionsDao {

	public void createTransferTransaction(Transactions transactions) throws Exception;

	public void createCreditTransaction(Transactions transactions)throws Exception;

	public void createDebitTransaction(Transactions transactions)throws Exception;
}
