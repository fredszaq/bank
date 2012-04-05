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
	 * Get a specific account of a user.
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

	/**
	 * Obtention des opérations carte pour un compte donné.
	 * 
	 * @param compteId
	 *            the compteId
	 * @param month
	 *            month
	 * @return Liste d'opération
	 */
	List<Operation> getOperationsCarteByCompteId(String compteId, Integer month);

	/**
	 * Obtention des opérations non carte pour un compte donné.
	 * 
	 * @param compteId
	 *            the compteId
	 * @param month
	 *            month
	 * @return Liste d'opération
	 */
	List<Operation> getOperationsNonCarteByCompteId(String compteId,
			Integer month);

	/**
	 * Obtention des opérations pour un compte donné.
	 * 
	 * @param compteId
	 *            the compteId
	 * @param month
	 *            month
	 * @return Liste d'opération
	 */
	List<Operation> getOperationsByCompteId(String compteId, Integer month);

	/**
	 * Obtention du total des opérations cartes pour un compte donné.
	 * 
	 * @param compteId
	 *            the compteId
	 * @param month
	 *            the month
	 * @return total
	 */
	double getTotalOperationsCarteByCompteId(String compteId, Integer month);

	long getTotalOperationsNonValideesByCompteId(String compteId);
}
