package com.excilys.formation.bank.dao;

import java.util.List;

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

	/**
	 * Set the last connection date to now.
	 * 
	 * @param login
	 *            the user to update
	 */
	void updateLastConnectionDate(String login);

	/**
	 * list all users.
	 * 
	 * @return all users
	 */
	List<User> getAll();

}
