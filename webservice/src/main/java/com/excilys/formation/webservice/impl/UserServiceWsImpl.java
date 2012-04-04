package com.excilys.formation.webservice.impl;

import java.util.List;
import java.util.Set;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.bean.Operation;
import com.excilys.formation.bank.bean.User;
import com.excilys.formation.webservice.UserServiceWs;

/**
 * UserService interface.
 * 
 * @author excilys
 * 
 */

public class UserServiceWsImpl implements UserServiceWs {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Compte getCompteByUsernameAndAccountId(String login, String id) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Set<Compte> getComptesByUsername(String login) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final User loadUserByUsername(String login) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<Operation> getOperationsCarteByCompteId(String compteId,
			Integer month) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<Operation> getOperationsNonCarteByCompteId(
			String compteId, Integer month) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final double getTotalOperationsCarteByCompteId(String compteId) {
		return 0;
	}

}
