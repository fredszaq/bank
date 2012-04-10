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
	 * @throws CompteNotFoundException
	 *             if the account wasn't found
	 */
	Compte getCompteById(String id) throws CompteNotFoundException;

	/**
	 * retrieve a Compte by id only if it belongs to the given user.
	 * 
	 * @param username
	 *            the username
	 * @param compteId
	 *            the compte id
	 * @return the compte
	 * @throws CompteNotFoundException
	 *             if the account wasn't found
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
	 * @throws CompteNotFoundException
	 *             if the account wasn't found
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
