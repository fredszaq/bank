package com.excilys.formation.bank.dao;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.DataSetTestExecutionListener;
import com.excilys.formation.bank.bean.Etat;
import com.excilys.formation.bank.bean.Etat.EtatType;
import com.excilys.formation.bank.bean.Transaction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:context/applicationContext*.xml",
		"classpath*:contextTest/applicationContext*.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DataSetTestExecutionListener.class })
@DataSet("/datasets/dataSetTransactionOperationDao.xml")
@Transactional
@TransactionConfiguration
public class TransactionDaoTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private TransactionDAO transactionDAO;

	@Autowired
	private EtatDAO etatDAO;

	private Transaction transaction;

	@Transactional(readOnly = true)
	@Before
	public final void init() {
		transaction = transactionDAO.getTransactionById(1);
	}

	@Test
	public final void getTransactionTest() {
		assertThat(transaction.getEtat().getEtatType().name()).isEqualTo(
				"VALIDATED");
	}

	@Test
	public void updateTransactionEtatTest() {
		Etat etat = etatDAO.getEtatByType(EtatType.WAITING);
		transaction.setEtat(etat);
		transactionDAO.update(transaction);
		assertThat(transaction.getEtat()).isEqualTo(etat);
	}

	@Test
	public final void deleteTransactionTest() {
		transactionDAO.delete(transaction);
		transaction = transactionDAO.getTransactionById(1);
		assertThat(transaction).isNull();
	}

	@Test
	public void insertTransactionTest() {
		Transaction transaction = new Transaction();
		transaction.setTransactionId(1);
		Etat etat = etatDAO.getEtatByType(EtatType.VALIDATED);
		transaction.setEtat(etat);
		Date date = new Date();
		transaction.setDateValid(date);
		transaction.setDateInit(date);
		transactionDAO.insert(transaction);
		transaction = transactionDAO.getTransactionById(1);
		assertThat(transaction).isEqualTo(transaction);
	}

	@After
	public final void end() {
		transaction = null;
		etatDAO = null;
		transactionDAO = null;
	}
}
