package com.excilys.formation.bank.dao;

import java.util.List;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.exception.CompteNotFoundException;

/**
 * Interface CompteDAO.
 * 
 * @author excilys
 * 
 */
public interface CompteDAO {

	/**
	 * retrieve a Compte by id.
	 * 
	 * @param id
	 *            the compte id
	 * @return the compte
	 */
	Compte getCompteById(String id) throws CompteNotFoundException;

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
	Compte getCompteByUsernameAndCompteId(String username, String compteId)
			throws CompteNotFoundException;

	/**
	 * update the Compte solde.
	 * 
	 * @param compteId
	 *            : the compteId
	 * @param difference
	 *            : the difference
	 */
	void updateSolde(String compteId, long difference)
			throws CompteNotFoundException;

	/**
	 * List all the accounts.
	 * 
	 * @return all the accounts
	 */
	List<Compte> getAll();

}
