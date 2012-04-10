package com.excilys.formation.bank.bean;

import java.io.Serializable;
import java.util.Set;
import java.util.SortedSet;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Sort;
import org.hibernate.annotations.SortType;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * User bean.
 * 
 * @author excilys
 * 
 */
@Entity
@Table(name = "utilisateur")
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

	@Column(name = "last_connection")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime lastConnection;

	@ManyToMany
	@JoinTable(name = "utilisateur_droit", joinColumns = { @JoinColumn(name = "login", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "authority_id", nullable = false, updatable = false) })
	private Set<Authority> authorities;

	@ManyToMany
	@JoinTable(name = "utilisateur_compte", joinColumns = @JoinColumn(name = "login"), inverseJoinColumns = @JoinColumn(name = "compte_id"))
	@Sort(type = SortType.NATURAL)
	private SortedSet<Compte> comptes;

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

	public final void setComptes(SortedSet<Compte> comptes) {
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

	public DateTime getLastConnection() {
		return lastConnection;
	}

	public void setLastConnection(DateTime lastConnection) {
		this.lastConnection = lastConnection;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password
				+ ", lastName=" + lastName + ", firstName=" + firstName
				+ ", address=" + address + ", lastConnection=" + lastConnection
				+ ", authorities=" + authorities + ", comptes=" + comptes + "]";
	}

}
