package com.excilys.formation.bank.bean;

import java.io.Serializable;

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
public class Authority implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2240814123594749921L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer authority_id;

	@Column
	private String login;

	@Column
	private String authority;

	public String getAuthority() {
		return this.authority;
	}

	public Integer getAuthority_id() {
		return this.authority_id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public void setAuthority_id(Integer authority_id) {
		this.authority_id = authority_id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
