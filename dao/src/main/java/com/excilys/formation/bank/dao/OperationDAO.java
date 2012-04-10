package com.excilys.formation.bank.dao;

import java.util.List;

import org.joda.time.Interval;

import com.excilys.formation.bank.bean.Operation;
import com.excilys.formation.bank.exception.OperationNotFoundException;

/**
 * Dao en charge des opérations.
 * 
 * @author excilys
 * 
 */
public interface OperationDAO {

	/**
	 * récupère une Operation.
	 * 
	 * @param id
	 *            : l'identifiant de l'opération
	 * @return l'opération trouvée s'il y a lieu
	 */
	Operation getOperationById(Integer id) throws OperationNotFoundException;

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
	List<Operation> searchOperationCarteFromCompteId(String compteId,
			Interval interval);

	/**
	 * Retourne le total des operations carte d'un compte.
	 * 
	 * @param compteId
	 *            l'id du compte dont il faut chercher les operations carte
	 * @param dateDebut
	 *            la date de debut
	 * @param dateFin
	 *            la date de fin
	 * @return le total des operations
	 */
	long searchTotalOperationCarteFromCompteId(String compteId,
			Interval interval);

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
	List<Operation> searchOperationNonCarteFromCompteId(String compteId,
			Interval interval);

	/**
	 * Retourne la liste des operations d'un compte.
	 * 
	 * @param compteId
	 *            l'id du compte dont il faut chercher les operations non carte
	 * @param dateDebut
	 *            : la date de début
	 * @param dateFin
	 *            : la date de fin
	 * @return la liste des operations
	 */
	List<Operation> searchOperationFromCompteId(String compteId,
			Interval interval);

	/**
	 * Retourne le total des operations non validées d'un compte.
	 * 
	 * @param compteId
	 *            l'id du compte dont il faut chercher les opérations
	 * @return le total des opérations
	 */
	long searchTotalOperationsNonValideesFromCompteId(String compteId);
}
