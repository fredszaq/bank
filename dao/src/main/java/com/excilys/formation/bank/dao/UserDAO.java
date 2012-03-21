package com.excilys.formation.bank.dao;

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
	 */
	User loadUserByUsername(String login);

}
