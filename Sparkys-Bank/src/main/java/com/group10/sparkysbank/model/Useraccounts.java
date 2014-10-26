package com.group10.sparkysbank.model;


// default package
// Generated Oct 26, 2014 3:05:06 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Useraccounts generated by hbm2java
 */
@Entity
@Table(name = "useraccounts", catalog = "sparkysbankdb")
public class Useraccounts implements java.io.Serializable {

	private String accountno;
	private Userinfo userinfo;
	private String routingno;
	private String wiringno;
	private Date accountopendate;
	private Integer balance;
	private Set<AccountCard> accountCards = new HashSet<AccountCard>(0);
	private Set<Transactions> transactionses = new HashSet<Transactions>(0);

	public Useraccounts() {
	}

	public Useraccounts(String accountno) {
		this.accountno = accountno;
	}

	public Useraccounts(String accountno, Userinfo userinfo, String routingno,
			String wiringno, Date accountopendate, Integer balance,
			Set<AccountCard> accountCards, Set<Transactions> transactionses) {
		this.accountno = accountno;
		this.userinfo = userinfo;
		this.routingno = routingno;
		this.wiringno = wiringno;
		this.accountopendate = accountopendate;
		this.balance = balance;
		this.accountCards = accountCards;
		this.transactionses = transactionses;
	}

	@Id
	@Column(name = "accountno", unique = true, nullable = false, length = 50)
	public String getAccountno() {
		return this.accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iduserinfo")
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@Column(name = "routingno", length = 45)
	public String getRoutingno() {
		return this.routingno;
	}

	public void setRoutingno(String routingno) {
		this.routingno = routingno;
	}

	@Column(name = "wiringno", length = 45)
	public String getWiringno() {
		return this.wiringno;
	}

	public void setWiringno(String wiringno) {
		this.wiringno = wiringno;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "accountopendate", length = 10)
	public Date getAccountopendate() {
		return this.accountopendate;
	}

	public void setAccountopendate(Date accountopendate) {
		this.accountopendate = accountopendate;
	}

	@Column(name = "balance")
	public Integer getBalance() {
		return this.balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "useraccounts")
	public Set<AccountCard> getAccountCards() {
		return this.accountCards;
	}

	public void setAccountCards(Set<AccountCard> accountCards) {
		this.accountCards = accountCards;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "useraccounts")
	public Set<Transactions> getTransactionses() {
		return this.transactionses;
	}

	public void setTransactionses(Set<Transactions> transactionses) {
		this.transactionses = transactionses;
	}

}
