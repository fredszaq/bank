package com.excilys.formation.bank.service.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.bean.Operation;
import com.excilys.formation.bank.bean.User;
import com.excilys.formation.bank.dao.CompteDAO;
import com.excilys.formation.bank.dao.OperationDAO;
import com.excilys.formation.bank.dao.UserDAO;
import com.excilys.formation.bank.service.UserService;

/**
 * Implementation of the UserService interface.
 * 
 * @author excilys
 * 
 */
@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private CompteDAO compteDAO;

	@Autowired
	private OperationDAO operationDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Compte getCompteByUsernameAndAccountId(String login, String id) {
		return compteDAO.loadCompteByUsernameAndCompteId(login, id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Set<Compte> getComptesByUsername(String login) {
		Set<Compte> comptes = userDAO.loadUserByUsername(login).getComptes();
		Hibernate.initialize(comptes);
		return comptes;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final User loadUserByUsername(String login)
			throws UsernameNotFoundException {
		User user = userDAO.loadUserByUsername(login);
		if (user == null) {
			throw new UsernameNotFoundException(login + " not found");
		}
		Hibernate.initialize(user.getAuthorities());
		return user;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<Operation> getOperationsCarteByCompteId(String compteId,
			Integer month) {
		DateTime dateDebut = new DateTime().withDayOfMonth(1)
				.minusMonths(month);
		DateTime dateFin = dateDebut.plusMonths(1).minusDays(1);
		return operationDAO.getOperationCarteFromCompteId(compteId,
				dateDebut.toDate(), dateFin.toDate());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<Operation> getOperationsNonCarteByCompteId(
			String compteId, Integer month) {
		DateTime dateDebut = new DateTime().withDayOfMonth(1)
				.minusMonths(month);
		DateTime dateFin = dateDebut.plusMonths(1).minusDays(1);
		return operationDAO.getOperationNonCarteFromCompteId(compteId,
				dateDebut.toDate(), dateFin.toDate());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<Operation> getOperationsByCompteId(String compteId,
			Integer month) {
		DateTime dateDebut = new DateTime().withDayOfMonth(1)
				.minusMonths(month);
		DateTime dateFin = dateDebut.plusMonths(1).minusDays(1);
		return operationDAO.getOperationFromCompteId(compteId,
				dateDebut.toDate(), dateFin.toDate());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final double getTotalOperationsCarteByCompteId(String compteId,
			Integer month) {
		DateTime dateDebut = new DateTime().withDayOfMonth(1)
				.minusMonths(month);
		DateTime dateFin = dateDebut.plusMonths(1).minusDays(1);
		return operationDAO.getTotalOperationCarteFromCompteId(compteId,
				dateDebut.toDate(), dateFin.toDate());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long getTotalOperationsNonValideesByCompteId(String compteId) {
		return operationDAO.getTotalOperationsNonValideesFromCompteId(compteId);
	}

}
