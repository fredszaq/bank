package com.excilys.formation.bank.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Entity
@Table(name = "users")
public class User {
	
	@Id
	private String login;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String lastname;

	@Column(nullable = false)
	private String firstname;

	@Column(nullable = true)
	private String address;

	@Column(nullable = false)
	private Authority authority;
	
	public User() {

	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Authority getAuthority() {
		return authority;
	}
	
	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	
	
}
