package com.excilys.formation.webservice;

import java.util.List;
import java.util.Set;

import javax.jws.WebParam;
import javax.jws.WebService;

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

@WebService(serviceName = "userService")
public interface UserServiceWs {

	/**
	 * Get a specific account of a user.
	 * 
	 * @param login
	 *            the login of the user
	 * @param id
	 *            the id of the account
	 * @return the account (null if not found)
	 */
	Compte getCompteByUsernameAndAccountId(
			@WebParam(name = "login") String login,
			@WebParam(name = "id") String id);

	/**
	 * Get the compte by username.
	 * 
	 * @param login
	 *            the login
	 * @return a set of compte
	 * @throws UsernameNotFoundException
	 */
	Set<Compte> getComptesByUsername(@WebParam(name = "login") String login);

	/**
	 * {@inheritDoc}
	 */
	User loadUserByUsername(@WebParam(name = "login") String login);

	/**
	 * Obtention des opérations carte pour un compte donné.
	 * 
	 * @param compteId
	 *            : the compteId
	 * @param month
	 *            : month
	 * @return Liste d'opération
	 */
	List<Operation> getOperationsCarteByCompteId(
			@WebParam(name = "compteId") String compteId,
			@WebParam(name = "month") Integer month);

	/**
	 * Obtention des opérations non carte pour un compte donné.
	 * 
	 * @param compteId
	 *            : the compteId
	 * @param month
	 *            : month
	 * @return Liste d'opération
	 */
	List<Operation> getOperationsNonCarteByCompteId(
			@WebParam(name = "compteId") String compteId,
			@WebParam(name = "month") Integer month);

	/**
	 * Obtention du total des opérations cartes pour un compte donné.
	 * 
	 * @param compteId
	 *            : the compteId
	 * @return total
	 */
	double getTotalOperationsCarteByCompteId(
			@WebParam(name = "compteId") String compteId);

}
