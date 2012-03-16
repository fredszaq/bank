package com.excilys.formation.bank.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Entity
@Table(name = "authorities")
public class Authority implements Serializable, GrantedAuthority {

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

	@Column
	private String authority;

	@Override
	public String getAuthority() {
		return this.authority;
	}

	public Integer getAuthority_id() {
		return this.authority_id;
	}

	public Set<User> getUser() {
		return this.users;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public void setAuthority_id(Integer authority_id) {
		this.authority_id = authority_id;
	}

	public void setUser(Set<User> users) {
		this.users = users;
	}

}
