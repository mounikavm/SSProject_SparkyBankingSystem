package com.group10.sparkysbank.model;


// default package
// Generated Oct 26, 2014 3:05:06 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Roles generated by hbm2java
 */
@Entity
@Table(name = "roles", catalog = "sparkysbankdb")
public class Roles implements java.io.Serializable {

	private String type;
	private Set<Userinfo> userinfos = new HashSet<Userinfo>(0);

	public Roles() {
	}

	public Roles(String type) {
		this.type = type;
	}

	public Roles(String type, Set<Userinfo> userinfos) {
		this.type = type;
		this.userinfos = userinfos;
	}

	@Id
	@Column(name = "type", unique = true, nullable = false, length = 45)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", catalog = "sparkysbankdb", joinColumns = { @JoinColumn(name = "role_type", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "iduserinfo", nullable = false, updatable = false) })
	public Set<Userinfo> getUserinfos() {
		return this.userinfos;
	}

	public void setUserinfos(Set<Userinfo> userinfos) {
		this.userinfos = userinfos;
	}

}
