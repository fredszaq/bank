package com.excilys.formation.bank.dao;

import java.util.Date;
import java.util.List;

import com.excilys.formation.bank.bean.Operation;

/**
 * Dao en charge des opérations.
 * 
 * @author excilys
 * 
 */
public interface OperationDAO {

	/**
	 * supprime une Operation.
	 * 
	 * @param operation
	 *            : l'identifiant de l'opération
	 */
	void delete(Operation operation);

	/**
	 * récupère une Operation.
	 * 
	 * @param id
	 *            : l'identifiant de l'opération
	 * @return l'opération trouvée s'il y a lieu
	 */
	Operation getOperationById(Integer id);

	/**
	 * insère une opération.
	 * 
	 * @param operation
	 *            l'opération à insérer
	 */
	void insert(Operation operation);

	/**
	 * met à jour une opération.
	 * 
	 * @param operation
	 *            l'opération à mettre à jour
	 */
	void update(Operation operation);

	/**
	 * Retourne la liste des operations carte d'un compte.
	 * 
	 * @param compteId
	 *            l'id du compte dont il faut chercher les operations carte
	 * @param dateDebut
	 *            : la date de début
	 * @param dateFin
	 *            : la date de fin
	 * @return la liste des operation
	 */
	List<Operation> getOperationCarteFromCompteId(String compteId,
			Date dateDebut, Date dateFin);

	/**
	 * Retourne le total des operations carte d'un compte.
	 * 
	 * @param compteId
	 *            l'id du compte dont il faut chercher les operations carte
	 * @return le total des operations
	 */
	long getTotalOperationCarteFromCompteId(String compteId);

	/**
	 * Retourne la liste des operations non carte d'un compte.
	 * 
	 * @param compteId
	 *            l'id du compte dont il faut chercher les operations non carte
	 * @param dateDebut
	 *            : la date de début
	 * @param dateFin
	 *            : la date de fin
	 * @return la liste des operations
	 */
	List<Operation> getOperationNonCarteFromCompteId(String compteId,
			Date dateDebut, Date dateFin);
}
