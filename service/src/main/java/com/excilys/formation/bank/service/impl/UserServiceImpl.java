package com.excilys.formation.bank.service.impl;

import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.bean.User;
import com.excilys.formation.bank.dao.UserDAO;
import com.excilys.formation.bank.service.UserService;

/**
 * Implementation of the UserService interface.
 * 
 * @author excilys
 * 
 */
@Service("userService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Set<Compte> getComptesByUsername(String login)
			throws UsernameNotFoundException {
		Set<Compte> comptes = this.userDAO.loadUserByUsername(login)
				.getComptes();
		Hibernate.initialize(comptes);
		return comptes;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final User loadUserByUsername(String login)
			throws UsernameNotFoundException {
		return this.userDAO.loadUserByUsername(login);
	}

}
