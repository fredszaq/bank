package com.excilys.formation.bank.service.impl;

import java.util.Date;
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
import com.excilys.formation.bank.service.VirementService;

@Service("virementService")
@Transactional
public class VirementServiceImpl implements VirementService {

	@Autowired
	private TransactionDAO transactionDAO;

	@Autowired
	private OperationDAO operationDAO;

	@Autowired
	private CompteDAO compteDAO;

	@Override
	public Transaction createVirement(String login, String compteDebiteurId,
			String compteCrediteurId, double montant, String libelle) {

		if (!compteCrediteurId.equals(compteDebiteurId)) {
			Compte compteDebiteurUser = compteDAO
					.loadCompteByUsernameAndCompteId(login, compteDebiteurId);
			if (compteDebiteurUser != null) {

				Transaction transaction = createTransaction(compteDebiteurId,
						compteCrediteurId, libelle);

				createOperations(compteDebiteurId, compteCrediteurId,
						transaction, montant);

				compteDAO.updateSolde(compteDebiteurId, -montant);
				compteDAO.updateSolde(compteCrediteurId, montant);
				return transaction;
			}
		}
		return null;
	}

	private void createOperations(String compteDebiteurId,
			String compteCrediteurId, Transaction transaction, double montant) {
		Operation operationDebit = new Operation();
		Operation operationCredit = new Operation();

		operationDebit.setMontant(montant);
		operationCredit.setMontant(montant);

		operationDebit.setOperationType(OperationType.DEBIT);
		operationCredit.setOperationType(OperationType.CREDIT);

		operationDebit.setTransaction(transaction);
		operationCredit.setTransaction(transaction);

		operationDebit.setCompte(compteDAO.loadCompteById(compteDebiteurId));
		operationCredit.setCompte(compteDAO.loadCompteById(compteCrediteurId));

		operationDAO.insert(operationDebit);
		operationDAO.insert(operationCredit);
	}

	private Transaction createTransaction(String compteDebiteurId,
			String compteCrediteurId, String libelle) {

		Compte compteDebiteur = compteDAO.loadCompteById(compteDebiteurId);
		Compte compteCrediteur = compteDAO.loadCompteById(compteCrediteurId);
		Set<User> usersDebiteurs = compteDebiteur.getUsers();
		Set<User> usersCrediteurs = compteCrediteur.getUsers();
		Set<User> userIntersection = new HashSet<User>(usersDebiteurs);
		userIntersection.retainAll(usersCrediteurs);

		Transaction transaction = new Transaction();
		Date now = new Date(DateTime.now().getMillis());
		transaction.setDateInit(now);
		transaction.setDateValid(now);

		if ("".equals(libelle)) {
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
