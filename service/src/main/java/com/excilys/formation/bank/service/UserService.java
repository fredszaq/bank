package com.excilys.formation.bank.service;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.bean.User;

/**
 * UserService interface.
 * 
 * @author excilys
 * 
 */
@Transactional
public interface UserService extends UserDetailsService {

	/**
	 * Get the compte by username.
	 * 
	 * @param login
	 *            the login
	 * @return a set of compte
	 * @throws UsernameNotFoundException
	 */
	@Transactional(readOnly = true)
	Set<Compte> getComptesByUsername(String login)
			throws UsernameNotFoundException;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	User loadUserByUsername(String login) throws UsernameNotFoundException;
}
