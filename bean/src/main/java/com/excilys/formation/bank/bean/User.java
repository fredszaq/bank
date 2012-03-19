package com.excilys.formation.bank.bean;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private String lastName;

	@Column
	private String firstName;

	@Column
	private String address;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Set<Authority> authorities;

	@OneToMany
	@JoinTable(name = "users_comptes", joinColumns = @JoinColumn(name = "login"), inverseJoinColumns = @JoinColumn(name = "compte_id"))
	private Set<Compte> comptes;

	public User() {

	}

	public User(String login, String password, String lastName,
			String firstName, String address, Set<Authority> authorities) {
		this.login = login;
		this.password = password;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.authorities = authorities;
	}

	public String getAddress() {
		return this.address;
	}

	@Override
	public Set<Authority> getAuthorities() {
		return this.authorities;
	}

<<<<<<< HEAD
	public Set<Compte> getComptes() {
		return this.comptes;
	}

	public String getFirstname() {
		return this.firstname;
=======
	public String getFirstName() {
		return this.firstName;
>>>>>>> modif login
	}

	public String getLastName() {
		return this.lastName;
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

<<<<<<< HEAD
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
=======
	public void setFirstName(String firstName) {
		this.firstName = firstName;
>>>>>>> modif login
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [login=").append(this.login).append(", password=")
				.append(this.password).append(", lastName=")
				.append(this.lastName).append(", firstName=")
				.append(this.firstName).append(", address=")
				.append(this.address).append("]");
		return builder.toString();
	}

}
