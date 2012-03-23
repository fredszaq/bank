package com.excilys.formation.bank.service;

import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.bean.Operation;
import com.excilys.formation.bank.bean.User;

/**
 * UserService interface.
 * 
 * @author excilys
 * 
 */

public interface UserService extends UserDetailsService {

	/**
	 * Get a specific account of a user
	 * 
	 * @param login
	 *            the login of the user
	 * @param id
	 *            the id of the account
	 * @return the account (null if not found)
	 */
	Compte getCompteByUsernameAndAccountId(String login, String id);

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

	List<Operation> getOperationsCarteByCompteId(String compteId);

	List<Operation> getOperationsNonCarteByCompteId(String compteId);

	double getTotalOperationsCarteByCompteId(String compteId);

}
