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
import com.excilys.formation.bank.bean.Etat.EtatType;
import com.excilys.formation.bank.bean.Operation;
import com.excilys.formation.bank.bean.OperationComptable;
import com.excilys.formation.bank.bean.OperationComptable.OperationComptableType;
import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.bank.bean.TransactionCategorie;
import com.excilys.formation.bank.bean.TransactionCategorie.TransactionCategorieType;
import com.excilys.formation.bank.bean.User;
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

	@Override
	@Transactional
	public void createVirement(Compte compteDebiteur, Compte compteCrediteur,
			double montant, String libelle) {

		Transaction transaction = createTransaction(compteDebiteur,
				compteCrediteur, libelle);

		createOperations(transaction, montant);

	}

	private void createOperations(Transaction transaction, double montant) {
		Operation operationDebit = new Operation();
		Operation operationCredit = new Operation();

		operationDebit.setMontant(montant);
		operationCredit.setMontant(montant);

		OperationComptable typeDebit = new OperationComptable();
		typeDebit.setOperationComptableType(OperationComptableType.DEBIT);

		OperationComptable typeCredit = new OperationComptable();
		typeDebit.setOperationComptableType(OperationComptableType.CREDIT);

		operationDebit.setOperationType(typeDebit);
		operationCredit.setOperationType(typeCredit);

		operationDAO.insert(operationDebit);
		operationDAO.insert(operationCredit);
	}

	private Transaction createTransaction(Compte compteDebiteur,
			Compte compteCrediteur, String libelle) {
		Set<User> usersDebiteurs = compteDebiteur.getUsers();
		Set<User> usersCrediteurs = compteCrediteur.getUsers();
		Set<User> userIntersection = new HashSet<User>(usersDebiteurs);
		userIntersection.retainAll(usersCrediteurs);

		Transaction transaction = new Transaction();
		Date now = new Date(DateTime.now().getMillis());
		transaction.setDateInit(now);

		if ("".equals(libelle)) {
			transaction.setLibelle("virement de "
					+ compteDebiteur.getCompteId() + " vers "
					+ compteCrediteur.getCompteId());
		} else {
			transaction.setLibelle(libelle);
		}

		TransactionCategorie categorie = new TransactionCategorie();

		if (userIntersection.isEmpty()) {
			categorie
					.setTransactionCategorieType(TransactionCategorieType.VIREMENT_EXTERNE);
			transaction.setTransactionCategorie(categorie);
		} else {
			categorie
					.setTransactionCategorieType(TransactionCategorieType.VIREMENT_INTERNE);
			transaction.setTransactionCategorie(categorie);
		}

		Etat etat = new Etat();
		etat.setEtatType(EtatType.VALIDATED);
		transaction.setEtat(etat);

		// Insertion de la transaction
		transactionDAO.insert(transaction);

		return transaction;
	}
}
