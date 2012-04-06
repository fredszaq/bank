package com.excilys.formation.bank.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

/**
 * Authority bean.
 * 
 * @author excilys
 * 
 */
@Entity
@Table(name = "droit")
public class Authority implements Serializable, GrantedAuthority {

	/**
	 * AuthorityType enum.
	 * 
	 * @author excilys
	 * 
	 */
	public enum AuthorityType {
		ROLE_AUTHENTICATED, ROLE_ADMIN;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2240814123594749921L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "authority_id")
	private Integer authorityId;

	@Enumerated(EnumType.STRING)
	private AuthorityType authority;

	@Override
	public final String getAuthority() {
		return authority.name();
	}

	public final Integer getAuthorityId() {
		return authorityId;
	}

	public final void setAuthority(AuthorityType authority) {
		this.authority = authority;
	}

	public final void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	@Override
	public final String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Authority [authorityId=").append(authorityId)
				.append(", authority=").append(authority).append("]");
		return builder.toString();
	}

}
