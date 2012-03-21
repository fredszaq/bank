package com.excilys.formation.bank.dao;

import com.excilys.formation.bank.bean.Compte;

public interface CompteDAO {

	/**
	 * Load a {@link Compte} giving its owning user and its id
	 * 
	 * @param login
	 *            the user login
	 * @param id
	 *            the Compte id
	 * @return the account (null if not found)
	 */
	Compte loadCompteByUsernameAndAccountId(String login, String id);
}
