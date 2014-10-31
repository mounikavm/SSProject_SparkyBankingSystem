package com.group10.sparkysbank.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group10.sparkysbank.dao.TransactionsDao;
import com.group10.sparkysbank.model.TransactionTypes;
import com.group10.sparkysbank.model.Transactions;
import com.group10.sparkysbank.model.Useraccounts;

@Service("fundManagementService")
public class FundManagementServiceImpl implements FundManagementService{

	@Autowired
	private TransactionsDao transactionsDao;
	
	@Autowired
	private AccountManagerService accountManagerService;
	
	@Transactional
	public void createTransferTransaction(Transactions transactions)
			throws Exception {
		// TODO Auto-generated method stub
		transactions.setApprovalNeeded(0);
		transactions.setApproved(0);
		transactions.setStatus(1);
		
		transactions.setTransactionTypes("TR_TRANSFER");
		
		String userName = "mou1";
		Useraccounts fromUserAccounts = accountManagerService.getUserAccountForUserName(userName);
		transactions.setFromAccount(fromUserAccounts.getAccountno());
		accountManagerService.updateBalance(fromUserAccounts.getAccountno(), transactions.getAmtInvolved(), "debit");
		
		accountManagerService.updateBalance(transactions.getToAccountno(), transactions.getAmtInvolved(), "credit");
		
		transactionsDao.createTransferTransaction(transactions);
		
		
	}

	@Transactional
	public void createCreditTransaction(Transactions transactions)
			throws Exception {
		// TODO Auto-generated method stub
		transactions.setApprovalNeeded(0);
		transactions.setApproved(0);
		transactions.setStatus(1);
		
		transactions.setTransactionTypes("TR_CREDIT");
		
		String userName = "mou1";
		Useraccounts fromUserAccounts = accountManagerService.getUserAccountForUserName(userName);
		transactions.setFromAccount(fromUserAccounts.getAccountno());
		
		accountManagerService.updateBalance(transactions.getFromAccount(), transactions.getAmtInvolved(), "credit");
		
		transactionsDao.createCreditTransaction(transactions);
	}

	@Transactional
	public void createDebitTransaction(Transactions transactions)
			throws Exception {
		// TODO Auto-generated method stub
		transactions.setApprovalNeeded(0);
		transactions.setApproved(0);
		transactions.setStatus(1);
		
		transactions.setTransactionTypes("TR_DEBIT");
		
		String userName = "mou1";
		Useraccounts fromUserAccounts = accountManagerService.getUserAccountForUserName(userName);
		transactions.setFromAccount(fromUserAccounts.getAccountno());
		
		accountManagerService.updateBalance(transactions.getFromAccount(), transactions.getAmtInvolved(), "debit");
		
		transactionsDao.createDebitTransaction(transactions);
		
	}

}
