package com.excilys.formation.bank.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.bean.Etat.EtatType;
import com.excilys.formation.bank.bean.Operation;
import com.excilys.formation.bank.bean.OperationComptable;
import com.excilys.formation.bank.bean.OperationComptable.OperationComptableType;
import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.bank.bean.TransactionCategorie.TransactionCategorieType;
import com.excilys.formation.bank.bean.User;
import com.excilys.formation.bank.dao.CompteDAO;
import com.excilys.formation.bank.dao.EtatDAO;
import com.excilys.formation.bank.dao.OperationComptableDAO;
import com.excilys.formation.bank.dao.OperationDAO;
import com.excilys.formation.bank.dao.TransactionCategorieDAO;
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

	@Autowired
	private EtatDAO etatDAO;

	@Autowired
	private TransactionCategorieDAO categorieDAO;

	@Autowired
	private OperationComptableDAO operationComptableDAO;

	@Override
	public void createVirement(String compteDebiteurId,
			String compteCrediteurId, double montant, String libelle) {

		Transaction transaction = createTransaction(compteDebiteurId,
				compteCrediteurId, libelle);

		createOperations(transaction, montant);

		compteDAO.updateSolde(compteDebiteurId, -montant);
		compteDAO.updateSolde(compteCrediteurId, montant);
	}

	private void createOperations(Transaction transaction, double montant) {
		Operation operationDebit = new Operation();
		Operation operationCredit = new Operation();

		operationDebit.setMontant(montant);
		operationCredit.setMontant(montant);

		OperationComptable typeDebit = operationComptableDAO
				.getOperationComptableByType(OperationComptableType.DEBIT);

		OperationComptable typeCredit = operationComptableDAO
				.getOperationComptableByType(OperationComptableType.CREDIT);

		operationDebit.setOperationType(typeDebit);
		operationCredit.setOperationType(typeCredit);

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
					.setTransactionCategorie(categorieDAO
							.getTransactionCategorieByType(TransactionCategorieType.VIREMENT_EXTERNE));
		} else {
			transaction
					.setTransactionCategorie(categorieDAO
							.getTransactionCategorieByType(TransactionCategorieType.VIREMENT_INTERNE));
		}

		transaction.setEtat(etatDAO.getEtatByType(EtatType.VALIDATED));

		// Insertion de la transaction
		transactionDAO.insert(transaction);

		return transaction;
	}
}
