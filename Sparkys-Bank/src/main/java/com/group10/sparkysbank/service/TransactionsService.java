package com.group10.sparkysbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group10.sparkysbank.dao.TransactionsDao;
import com.group10.sparkysbank.dao.UseraccountsDao;
import com.group10.sparkysbank.model.Transactions;

@Service("transactionsService ")
public class TransactionsService {
	
	@Autowired
	TransactionsDao transactionsDAO;
	
	@Autowired
	UseraccountsDao useraccountsDAO;

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
	
	@Transactional
	public List<Transactions> getTransToBeApproved(String role)
	{
         return this.transactionsDAO.getTransToBeApproved(role);
	}
	
	@Transactional
	public void updateTrans(Transactions trans)
	{
         Transactions trans1 = this.transactionsDAO.updateTrans(trans);
	}
	
	@Transactional
	public List<Transactions> getExtUserReqList(String role)
	{
         return this.transactionsDAO.getExtUserReqList(role);
	}
	
	@Transactional
	public String extUsrProfileViewReq(String username)
	{
		String message = "No Action could be taken";
		Transactions transaction = new Transactions();
		transaction.setApprovalNeeded(1);
		transaction.setStatus(1);
		transaction.setTransactionTypes("TR_VIEW");
		int accno = 0;
		int count = -1;
		try {
			accno = (useraccountsDAO.getAccountByUsername(username)).getAccountno();
			//check if any other record exists with the same account no
			count = transactionsDAO.countOfReqForAcc("TR_VIEW",accno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count!=0)
			message="A pending view request already exits. You can directly go ahead and view the proile.";
		else {
			if (accno != 0) {
				transaction.setFromAccount(accno);
				try {
					transactionsDAO.createViewExtProfileTrans(transaction);
					message = "Request to view the user's profile forwarded. Please wait till approved.";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return message;
	}
}