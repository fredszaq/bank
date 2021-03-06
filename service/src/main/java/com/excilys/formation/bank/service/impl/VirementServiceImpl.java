package com.excilys.formation.bank.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.bean.Etat;
import com.excilys.formation.bank.bean.Operation;
import com.excilys.formation.bank.bean.OperationType;
import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.bank.bean.TransactionCategorie;
import com.excilys.formation.bank.bean.User;
import com.excilys.formation.bank.dao.CompteDAO;
import com.excilys.formation.bank.dao.OperationDAO;
import com.excilys.formation.bank.dao.TransactionDAO;
import com.excilys.formation.bank.exception.CompteNotFoundException;
import com.excilys.formation.bank.service.VirementService;

/**
 * Implémentation de l'interface VirementService
 * 
 * @author excilys
 * 
 */
@Service("virementService")
@Transactional
public class VirementServiceImpl implements VirementService {

	@Autowired
	private TransactionDAO transactionDAO;

	@Autowired
	private OperationDAO operationDAO;

	@Autowired
	private CompteDAO compteDAO;

	/**
	 * {@inheritDoc}
	 * 
	 * @throws CompteNotFoundException
	 */
	@Override
	public final Transaction createVirement(String login,
			String compteDebiteurId, String compteCrediteurId, long montant,
			String libelle) throws CompteNotFoundException {
		if (compteCrediteurId.equals(compteDebiteurId)) {
			throw new IllegalArgumentException(
					"the two ComptesId must be different !");

		}
		Compte compteDebiteur = compteDAO.getCompteByUsernameAndCompteId(login,
				compteDebiteurId);
		/*
		 * if (compteDebiteur == null) { throw new IllegalArgumentException(
		 * "unable to find this Compte for this user.");
		 * 
		 * }
		 */

		Compte compteCrediteur = compteDAO.getCompteById(compteCrediteurId);

		Transaction transaction = createTransaction(compteDebiteur,
				compteCrediteur, libelle);

		createOperations(compteDebiteur, compteCrediteur, transaction, montant);

		compteDAO.updateSolde(compteDebiteurId, -montant);
		compteDAO.updateSolde(compteCrediteurId, montant);
		return transaction;
	}

	/**
	 * Création de l'opération associée à la transaction de type virement.
	 * 
	 * @param compteDebiteur
	 *            : compte débiteur
	 * @param compteCrediteur
	 *            : compte créditeur
	 * @param transaction
	 *            : la transaction
	 * @param montant
	 *            : le montant
	 */
	private void createOperations(Compte compteDebiteur,
			Compte compteCrediteur, Transaction transaction, long montant) {
		Operation operationDebit = new Operation();
		Operation operationCredit = new Operation();

		operationDebit.setMontant(montant);
		operationCredit.setMontant(montant);

		operationDebit.setOperationType(OperationType.DEBIT);
		operationCredit.setOperationType(OperationType.CREDIT);

		operationDebit.setTransaction(transaction);
		operationCredit.setTransaction(transaction);

		operationDebit.setCompte(compteDebiteur);
		operationCredit.setCompte(compteCrediteur);

		operationDAO.insert(operationDebit);
		operationDAO.insert(operationCredit);
	}

	/**
	 * Création d'une transaction de type virement.
	 * 
	 * @param compteDebiteur
	 *            : compte débiteur
	 * @param compteCrediteur
	 *            : compte créditeur
	 * @param libelle
	 *            : libellé
	 * @return Transation
	 */
	private Transaction createTransaction(Compte compteDebiteur,
			Compte compteCrediteur, String libelle) {

		Set<User> usersDebiteurs = compteDebiteur.getUsers();
		Set<User> usersCrediteurs = compteCrediteur.getUsers();
		Set<User> userIntersection = new HashSet<User>(usersDebiteurs);
		userIntersection.retainAll(usersCrediteurs);

		Transaction transaction = new Transaction();
		DateTime now = new DateTime();
		transaction.setDateInit(now);
		transaction.setDateValid(now);

		if (libelle == null) {
			transaction.setLibelle("virement de "
					+ compteDebiteur.getCompteId() + " vers "
					+ compteCrediteur.getCompteId());
		} else {
			transaction.setLibelle(libelle);
		}

		if (userIntersection.isEmpty()) {
			transaction
					.setTransactionCategorie(TransactionCategorie.VIREMENT_EXTERNE);
		} else {
			transaction
					.setTransactionCategorie(TransactionCategorie.VIREMENT_INTERNE);
		}

		transaction.setEtat(Etat.VALIDATED);

		// Insertion de la transaction
		transactionDAO.insert(transaction);

		return transaction;
	}
}
