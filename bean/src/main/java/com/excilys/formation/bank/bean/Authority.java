package com.excilys.formation.bank.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
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

/**
 * Authority bean.
 * 
 * @author excilys
 * 
 */
@Entity
@Table(name = "authorities")
public class Authority implements Serializable, GrantedAuthority {

	/**
	 * AuthorityType enum.
	 * 
	 * @author excilys
	 * 
	 */
	public enum AuthorityType {
		ROLE_AUTHENTICATED("ROLE_AUTHENTICATED"), ROLE_ADMIN("ROLE_ADMIN");

		private final String value;

		/**
		 * Logical constructor.
		 * 
		 * @param value
		 */
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
	@Column(name = "authority_id")
	private Integer authorityId;

	@ManyToMany
	@JoinTable(name = "users_authorities", joinColumns = { @JoinColumn(name = "authority_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "login", nullable = false, updatable = false) })
	private Set<User> users;

	@Enumerated(EnumType.STRING)
	private AuthorityType authority;

	/**
	 * Default constructor.
	 */
	public Authority() {

	}

	/**
	 * Logical constructor.
	 * 
	 * @param authority
	 *            the authority
	 */
	public Authority(AuthorityType authority) {
		this.authority = authority;
	}

	@Override
	public final String getAuthority() {
		return this.authority.getValue();
	}

	public final Integer getAuthorityId() {
		return this.authorityId;
	}

	public final Set<User> getUser() {
		return this.users;
	}

	public final void setAuthority(AuthorityType authority) {
		this.authority = authority;
	}

	public final void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	public final void setUser(Set<User> users) {
		this.users = users;
	}

}
