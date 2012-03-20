package com.excilys.formation.bank.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "authorities")
public class Authority implements Serializable, GrantedAuthority {

	public enum AuthorityType {
		ROLE_AUTHENTICATED("ROLE_AUTHENTICATED"), ROLE_ADMIN("ROLE_ADMIN");

		private final String value;

		private AuthorityType(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2240814123594749921L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer authority_id;

	@ManyToMany
	@JoinTable(name = "users_authorities", joinColumns = { @JoinColumn(name = "authority_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "login", nullable = false, updatable = false) })
	private Set<User> users;

	@Enumerated(EnumType.STRING)
	private AuthorityType authority;

	// private String authority;

	public Authority() {

	}

	public Authority(AuthorityType authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return this.authority.getValue();
	}

	public Integer getAuthority_id() {
		return this.authority_id;
	}

	public Set<User> getUser() {
		return this.users;
	}

	public void setAuthority(AuthorityType authority) {
		this.authority = authority;
	}

	public void setAuthority_id(Integer authority_id) {
		this.authority_id = authority_id;
	}

	public void setUser(Set<User> users) {
		this.users = users;
	}

}
