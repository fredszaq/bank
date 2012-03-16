package com.excilys.formation.bank.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Entity
@Table(name = "authorities")
public enum Authority {
	ROLE_AUTHENTICATED(1, "ROLE_AUTHENTICATED"), ROLE_ADMIN(2, "ROLE_ADMIN");

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Integer authority_id;

	@Column
	private final String authority;

	private Authority() {
		this.authority_id = null;
		this.authority = null;
	}

	private Authority(Integer authority_id, String authority) {
		this.authority = authority;
		this.authority_id = authority_id;
	}

	public String getAuthority() {
		return this.authority;
	}

	public Integer getAuthority_id() {
		return this.authority_id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Authority [authority_id=").append(this.authority_id)
				.append(", authority=").append(this.authority).append("]");
		return builder.toString();
	}
}
