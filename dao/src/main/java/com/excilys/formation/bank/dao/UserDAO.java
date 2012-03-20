package com.excilys.formation.bank.dao;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.excilys.formation.bank.bean.User;

/**
 * UserDAO Interface.
 * 
 * @author excilys
 * 
 */
public interface UserDAO {

	/**
	 * Load user by username.
	 * 
	 * @param login
	 *            the login
	 * @return user
	 * @throws UsernameNotFoundException
	 *             throws when the username is unknown
	 */
	User loadUserByUsername(String login) throws UsernameNotFoundException;
}
