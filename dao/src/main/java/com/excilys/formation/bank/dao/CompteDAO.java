package com.excilys.formation.bank.dao;

import com.excilys.formation.bank.bean.Compte;

public interface CompteDAO {

	/**
	 * retrieve a Compte by id.
	 * 
	 * @param id
	 *            the compte id
	 * @return the compte
	 */
	Compte loadCompteById(String id);

	/**
	 * retrieve a Compte by id only if it belongs to the given user.
	 * 
	 * @param username
	 *            the username
	 * @param compteId
	 *            the compte id
	 * @return the compte (or null if the COmpte doesn't exists or isn't owned
	 *         by the user
	 */
	Compte loadCompteByUsernameAndCompteId(String username, String compteId);

	/**
	 * update the Compte solde.
	 * 
	 * @param compteId
	 * @param difference
	 */
	void updateSolde(String compteId, double difference);
}
