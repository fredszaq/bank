package com.excilys.formation.bank.service;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Date;

import org.junit.After;
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
import com.excilys.formation.bank.bean.Etat;
import com.excilys.formation.bank.bean.Etat.EtatType;
import com.excilys.formation.bank.bean.Transaction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:context/applicationContext*.xml",
		"classpath*:contextTest/applicationContext*.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DataSetTestExecutionListener.class })
@DataSet("/datasets/dataSetService.xml")
public class TestTransactionService {
	@Autowired
	private TransactionService transactionService;

	@Autowired
	private EtatService etatService;

	private Transaction transaction;

	@Before
	public final void init() {
		transaction = transactionService.getTransactionById(1);
	}

	@Test
	public final void getTransactionTest() {
		assertThat(transaction.getEtat().getEtatType().name()).isEqualTo(
				"VALIDATED");
	}

	@Test
	public void updateTransactionEtatTest() {
		transactionService.update(transaction, EtatType.WAITING);
		assertThat(transaction.getEtat().getEtatType()).isEqualTo(
				EtatType.WAITING);
	}

	@Test
	public void insertTransactionTest() {
		Transaction transaction = new Transaction();
		transaction.setTransactionId(1);
		Etat etat = etatService.getEtatByType(EtatType.VALIDATED);
		transaction.setEtat(etat);
		Date date = new Date();
		transaction.setDateValid(date);
		transaction.setDateInit(date);
		transactionService.insert(transaction);
		transaction = transactionService.getTransactionById(1);
		assertThat(transaction).isEqualTo(transaction);
	}

	@After
	public final void end() {
		transaction = null;
		etatService = null;
		transactionService = null;
	}
}
