package com.excilys.formation.bank.service;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.bean.User;

/**
 * UserService interface.
 * 
 * @author excilys
 * 
 */

public interface UserService extends UserDetailsService {

	/**
	 * Get the compte by username.
	 * 
	 * @param login
	 *            the login
	 * @return a set of compte
	 * @throws UsernameNotFoundException
	 */
	Set<Compte> getComptesByUsername(String login);

	/**
	 * {@inheritDoc}
	 */
	@Override
	User loadUserByUsername(String login);
}
