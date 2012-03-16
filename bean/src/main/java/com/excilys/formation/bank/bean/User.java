package com.excilys.formation.bank.bean;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Entity
@Table(name = "users")
public class User implements Serializable, UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1695314120127290908L;

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

	@Column(name = "authority_id", nullable = false)
	private Authority authority;

	public User() {

	}

	public String getAddress() {
		return this.address;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	public Authority getAuthority() {
		return this.authority;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public String getLogin() {
		return this.login;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [login=").append(this.login).append(", password=")
				.append(this.password).append(", lastname=")
				.append(this.lastname).append(", firstname=")
				.append(this.firstname).append(", address=")
				.append(this.address).append(", authority=")
				.append(this.authority).append("]");
		return builder.toString();
	}

}
