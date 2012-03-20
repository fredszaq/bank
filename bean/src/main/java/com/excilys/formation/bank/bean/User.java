package com.excilys.formation.bank.bean;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * User bean.
 * 
 * @author excilys
 * 
 */
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

	@ManyToMany
	@JoinTable(name = "users_authorities", joinColumns = { @JoinColumn(name = "login", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "authority_id", nullable = false, updatable = false) })
	private Set<Authority> authorities;

	@ManyToMany
	@JoinTable(name = "users_comptes", joinColumns = @JoinColumn(name = "login"), inverseJoinColumns = @JoinColumn(name = "compte_id"))
	private Set<Compte> comptes;

	public final String getAddress() {
		return address;
	}

	@Override
	public final Set<Authority> getAuthorities() {
		return authorities;
	}

	public final Set<Compte> getComptes() {
		return comptes;
	}

	public final String getFirstName() {
		return firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final String getLogin() {
		return login;
	}

	@Override
	public final String getPassword() {
		return password;
	}

	@Override
	public final String getUsername() {
		return login;
	}

	@Override
	public final boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public final boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public final boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public final boolean isEnabled() {
		return true;
	}

	public final void setAddress(String address) {
		this.address = address;
	}

	public final void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public final void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public final void setLogin(String login) {
		this.login = login;
	}

	@Override
	public final String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [login=").append(login).append(", password=")
				.append(password).append(", lastName=").append(lastName)
				.append(", firstName=").append(firstName).append(", address=")
				.append(address).append("]");
		return builder.toString();
	}
}
