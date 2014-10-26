package com.group10.sparkysbank.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AccountCard generated by hbm2java
 */
@Entity
@Table(name = "account_card", catalog = "sparkysbankdb")
public class AccountCard implements java.io.Serializable {

	private int idaccountCard;
	private String cardno;
	private String cvv;
	private String expiryMonth;
	private String expiryYear;

	public AccountCard() {
	}

	public AccountCard(int idaccountCard) {
		this.idaccountCard = idaccountCard;
	}

	public AccountCard(int idaccountCard,
			String cardno, String cvv, String expiryMonth, String expiryYear) {
		this.idaccountCard = idaccountCard;
		this.cardno = cardno;
		this.cvv = cvv;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
	}

	@Id
	@Column(name = "idaccount_card", unique = true, nullable = false)
	public int getIdaccountCard() {
		return this.idaccountCard;
	}

	public void setIdaccountCard(int idaccountCard) {
		this.idaccountCard = idaccountCard;
	}

	@Column(name = "cardno", length = 45)
	public String getCardno() {
		return this.cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	@Column(name = "cvv", length = 45)
	public String getCvv() {
		return this.cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@Column(name = "expiry_month", length = 45)
	public String getExpiryMonth() {
		return this.expiryMonth;
	}

	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	@Column(name = "expiry_year", length = 45)
	public String getExpiryYear() {
		return this.expiryYear;
	}

	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

}
