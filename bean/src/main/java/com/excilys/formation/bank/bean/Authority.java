package com.excilys.formation.bank.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Entity
@Table(name = "authorities")
public enum Authority {
	ROLE_AUTHENTICATED(1, "ROLE_AUTHENTICATED"),
	ROLE_ADMIN(2, "ROLE_ADMIN");

	@Column(nullable = false)
	private final Integer authority_id;

	@Column(nullable = false)
	private final String authority;

	private Authority(Integer authority_id, String authority){
		this.authority = authority;
		this.authority_id = authority_id;
	}

	public Integer getAuthority_id() {
		return authority_id;
	}

	public String getAuthority() {
		return authority;
	}
	
}
