package com.group10.sparkysbank.model;


// default package
// Generated Oct 26, 2014 3:05:06 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Userinfo generated by hbm2java
 */
@Entity
@Table(name = "userinfo", catalog = "sparkysbankdb", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Userinfo implements java.io.Serializable {
	
	private int iduserinfo;
	@NotEmpty
	private String firstname;
	@NotEmpty
	private String middlename;
	@NotEmpty
	private String lastname;
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;

	private Date dob;
	@NotEmpty
	private String address;
	@NotEmpty
	private String identificationid;
	
	private Date expirydate;
	private Set<Pwdrecovery> pwdrecoveries = new HashSet<Pwdrecovery>(0);
	private Set<Roles> roleses = new HashSet<Roles>(0);
	private Set<Useraccounts> useraccountses = new HashSet<Useraccounts>(0);

	public Userinfo() {
	}

	public Userinfo(int iduserinfo) {
		this.iduserinfo = iduserinfo;
	}

	public Userinfo(int iduserinfo, String firstname, String middlename,
			String lastname, String username, String password, Date dob,
			String address, String identificationid, Date expirydate,
			Set<Pwdrecovery> pwdrecoveries, Set<Roles> roleses,
			Set<Useraccounts> useraccountses) {
		this.iduserinfo = iduserinfo;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.address = address;
		this.identificationid = identificationid;
		this.expirydate = expirydate;
		this.pwdrecoveries = pwdrecoveries;
		this.roleses = roleses;
		this.useraccountses = useraccountses;
	}

	@Id
	@Column(name = "iduserinfo", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIduserinfo() {
		return this.iduserinfo;
	}

	public void setIduserinfo(int iduserinfo) {
		this.iduserinfo = iduserinfo;
	}

	@Column(name = "firstname", length = 45)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "middlename", length = 45)
	public String getMiddlename() {
		return this.middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	@Column(name = "lastname", length = 45)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "username", unique = true, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 60)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dob", length = 10)
	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "address", length = 45)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "identificationid", length = 45)
	public String getIdentificationid() {
		return this.identificationid;
	}

	public void setIdentificationid(String identificationid) {
		this.identificationid = identificationid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "expirydate", length = 10)
	public Date getExpirydate() {
		return this.expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Pwdrecovery> getPwdrecoveries() {
		return this.pwdrecoveries;
	}

	public void setPwdrecoveries(Set<Pwdrecovery> pwdrecoveries) {
		this.pwdrecoveries = pwdrecoveries;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", catalog = "sparkysbankdb", joinColumns = { @JoinColumn(name = "iduserinfo", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "role_type", nullable = false, updatable = false) })
	public Set<Roles> getRoleses() {
		return this.roleses;
	}

	public void setRoleses(Set<Roles> roleses) {
		this.roleses = roleses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userinfo")
	public Set<Useraccounts> getUseraccountses() {
		return this.useraccountses;
	}

	public void setUseraccountses(Set<Useraccounts> useraccountses) {
		this.useraccountses = useraccountses;
	}

}
