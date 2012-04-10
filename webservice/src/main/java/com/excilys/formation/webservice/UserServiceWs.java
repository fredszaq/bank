package com.excilys.formation.webservice;

import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.excilys.formation.dto.CompteDTO;

/**
 * UserServiceWs interface.
 * 
 * @author excilys
 * 
 */

@WebService
public interface UserServiceWs {

	/**
	 * Get the compte by username.
	 * 
	 * @param login
	 *            the login
	 * @return a set of compte
	 * @throws UsernameNotFoundException
	 */
	@WebMethod
	Set<CompteDTO> getComptesByUsername(@WebParam(name = "login") String login);

	/**
	 * Get a specific account of a user.
	 * 
	 * @param login
	 *            the login of the user
	 * @param id
	 *            the id of the account
	 * @return the account (null if not found)
	 */
	@WebMethod
	CompteDTO getCompteByUsernameAndAccountId(
			@WebParam(name = "login") String login,
			@WebParam(name = "lid") String id);

}
