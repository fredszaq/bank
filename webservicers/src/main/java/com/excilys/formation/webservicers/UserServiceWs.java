package com.excilys.formation.webservicers;

import java.util.Set;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.excilys.formation.webservicers.dto.bean.CompteDTO;

/**
 * UserService interface.
 * 
 * @author excilys
 * 
 */

public interface UserServiceWs {

	/**
	 * Get the compte by username.
	 * 
	 * @param login
	 *            the login
	 * @return a set of compte
	 * @throws UsernameNotFoundException
	 */
	Set<CompteDTO> getComptesByUsername(String login);

	/**
	 * Get a specific account of a user.
	 * 
	 * @param login
	 *            the login of the user
	 * @param id
	 *            the id of the account
	 * @return the account (null if not found)
	 */
	CompteDTO getCompteByUsernameAndAccountId(String login, String id);

}
