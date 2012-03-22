package com.excilys.formation.bank.dao;

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
	 * @param operationId
	 *            l'identifiant de l'opération
	 */
	void deleteByOperationId(Integer operationId);

	/**
	 * récupère une Operation.
	 * 
	 * @param id
	 *            l'identifiant de l'opération
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
	 * met à jour une opération
	 * 
	 * @param operation
	 *            l'opération à mettre à jour
	 */
	void update(Operation operation);
}
