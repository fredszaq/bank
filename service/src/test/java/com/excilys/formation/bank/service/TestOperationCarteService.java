package com.excilys.formation.bank.service;

import static org.fest.assertions.Assertions.assertThat;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.DataSetTestExecutionListener;
import com.excilys.formation.bank.bean.Transaction;
import com.excilys.formation.bank.bean.TransactionCategorie;
import com.excilys.formation.bank.exception.CompteNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:context/applicationContext*.xml",
		"classpath:contextTest/applicationContext-serviceTest.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DataSetTestExecutionListener.class })
@DataSet("/datasets/dataSetService.xml")
public class TestOperationCarteService {

	@Autowired
	private OperationCarteService operationCarteService;

	@Autowired
	private UserService userService;

	@Before
	public final void init() {
	}

	@Test
	public final void creationOperationCarteTest()
			throws CompteNotFoundException {
		double soldeInitialDebiteur = userService
				.getCompteByUsernameAndAccountId("user1", "compte1").getSolde();
		DateTime now = DateTime.now();
		Transaction transaction = operationCarteService.createOperationCarte(
				"user1", "compte1", 35, "oh la belle opération carte");

		assertThat(transaction.getLibelle()).isEqualTo(
				"oh la belle opération carte");

		// VÉRIFICATION DE LA DATE INITIALE DE TRANSACTION
		transaction.getDateInit();
		DateTime dateTransactionInit = new DateTime(transaction.getDateInit());
		assertThat(Days.daysBetween(now, dateTransactionInit).getDays())
				.isEqualTo(0);

		// VÉRIFICATION DE LA DATE FINALE DE TRANSACTION
		DateTime dateTransactionValid = new DateTime(transaction.getDateValid());
		assertThat(Days.daysBetween(now, dateTransactionValid).getDays())
				.isEqualTo(0);

		// SOLDES FINAUX
		double soldeFinalDebiteur = userService
				.getCompteByUsernameAndAccountId("user1", "compte1").getSolde();
		assertThat(soldeFinalDebiteur).isEqualTo(soldeInitialDebiteur - 35);

		// OPERATION CARTE
		assertThat(transaction.getTransactionCategorie()).isEqualTo(
				TransactionCategorie.CARTE);
	}

	@Test(expected = Exception.class)
	public final void creationOperationCarteMontantNegatifTest()
			throws CompteNotFoundException {
		operationCarteService.createOperationCarte("user1", "compte1", -100,
				"marche pas");
	}

	@Test(expected = Exception.class)
	public final void creationOperationCompteNApartenantPasALUser()
			throws CompteNotFoundException {
		operationCarteService.createOperationCarte("user1", "compte3", 100,
				"marche pas");
	}

	@Test(expected = Exception.class)
	public final void creationOperationCompteSansCarte()
			throws CompteNotFoundException {
		operationCarteService.createOperationCarte("user1", "compte2", 100,
				"marche pas");
	}
}
