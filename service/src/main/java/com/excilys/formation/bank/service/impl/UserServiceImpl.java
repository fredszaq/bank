package com.excilys.formation.bank.service.impl;

import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.bean.User;
import com.excilys.formation.bank.dao.CompteDAO;
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
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private CompteDAO compteDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Compte getCompteByUsernameAndAccountId(String login, String id) {
		Compte compte = compteDAO.loadCompteByUsernameAndAccountId(login, id);
		// TODO Hibernate.initialise(compte.getOperations()) ?
		return compte;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Set<Compte> getComptesByUsername(String login) {
		Set<Compte> comptes = userDAO.loadUserByUsername(login).getComptes();
		Hibernate.initialize(comptes);
		return comptes;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final User loadUserByUsername(String login)
			throws UsernameNotFoundException {
		User user = userDAO.loadUserByUsername(login);
		if (user == null) {
			throw new UsernameNotFoundException(login + " not found");
		}
		Hibernate.initialize(user.getAuthorities());
		return user;
	}

}
