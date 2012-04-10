package com.excilys.formation.bank.dao;

import com.excilys.formation.bank.bean.User;
import com.excilys.formation.bank.exception.UserNotFoundException;

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
	User loadUserByUsername(String login) throws UserNotFoundException;

	void updatelastConnectionDate(String login);

}
