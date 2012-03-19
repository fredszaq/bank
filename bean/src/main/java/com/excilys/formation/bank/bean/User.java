package com.excilys.formation.bank.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class User implements Serializable, UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1695314120127290908L;

	@Id
	@Generated("assigned")
	private String login;

	@Column
	private String password;

	@Column
	private String lastname;

	@Column
	private String firstname;

	@Column
	private String address;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<Authority> authorities;

	public User() {

	}

	public User(String login, String password, String lastname,
			String firstname, String address, Set<Authority> authorities) {
		this.login = login;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
		this.address = address;
		this.authorities = authorities;
	}

	public String getAddress() {
		return this.address;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
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

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [login=").append(this.login).append(", password=")
				.append(this.password).append(", lastname=")
				.append(this.lastname).append(", firstname=")
				.append(this.firstname).append(", address=")
				.append(this.address).append("]");
		return builder.toString();
	}

}
