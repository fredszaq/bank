package com.excilys.formation.bank.service;

import static org.fest.assertions.Assertions.assertThat;

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

	private Transaction transaction;

	@Before
	public final void init() {
		transaction = transactionService.getTransactionById(1);
	}

	@Test
	public final void getTransactionTest() {
		System.err.println("test");
		assertThat(transaction.getEtat().name()).isEqualTo("VALIDATED");
	}

	@Test
	public void updateTransactionEtatTest() {
		/*
		 * transactionService.update(transaction, Etat.WAITING);
		 * assertThat(transaction.getEtat()).isEqualTo(Etat.WAITING);
		 */
	}

	@Test
	public void insertTransactionTest() {
		/*
		 * Transaction transaction = new Transaction();
		 * transaction.setTransactionId(1); Etat etat =
		 * etatService.getEtatByType(Etat.VALIDATED); transaction.setEtat(etat);
		 * Date date = new Date(); transaction.setDateValid(date);
		 * transaction.setDateInit(date);
		 * transactionService.insert(transaction); transaction =
		 * transactionService.getTransactionById(1);
		 * assertThat(transaction).isEqualTo(transaction);
		 */
	}

	@After
	public final void end() {
		transaction = null;
		transactionService = null;
	}
}
