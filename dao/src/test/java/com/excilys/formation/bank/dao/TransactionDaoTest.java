package com.excilys.formation.bank.dao;

import static org.fest.assertions.Assertions.assertThat;

import org.joda.time.DateTime;
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
import com.excilys.formation.bank.bean.Transaction;

/**
 * Test de la classe TransactionDAO.
 * 
 * @author excilys
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:context/applicationContext*.xml",
		"classpath:contextTest/applicationContext-daoTest.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DataSetTestExecutionListener.class })
@DataSet("/datasets/dataSetTransactionOperationDao.xml")
@Transactional
@TransactionConfiguration
public class TransactionDaoTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private TransactionDAO transactionDAO;

	private Transaction transaction;

	/**
	 * Méthode d'initialisation avant chaque test.
	 */
	@Transactional(readOnly = true)
	@Before
	public final void init() {
		transaction = transactionDAO.getTransactionById(1);
	}

	/**
	 * Test obtention d'une transaction.
	 */
	@Test
	public final void getTransactionTest() {
		System.out.println(transaction.getEtat());
		assertThat(transaction.getEtat().name()).isEqualTo("VALIDATED");
	}

	/**
	 * Test mise à jour d'une transaction.
	 */
	@Test
	public final void updateTransactionEtatTest() {
		transaction.setEtat(Etat.WAITING);
		transactionDAO.update(transaction);
		assertThat(transaction.getEtat()).isEqualTo(Etat.WAITING);

	}

	/**
	 * Test insertion d'une transaction.
	 */
	@Test
	public final void insertTransactionTest() {
		Transaction transactionToInsert = new Transaction();
		transactionToInsert.setTransactionId(1);
		transactionToInsert.setEtat(Etat.VALIDATED);
		DateTime date = new DateTime();
		transactionToInsert.setDateValid(date);
		transactionToInsert.setDateInit(date);
		transactionDAO.insert(transactionToInsert);
		transaction = transactionDAO.getTransactionById(4);
		assertThat(transaction.getTransactionId()).isEqualTo(
				transactionToInsert.getTransactionId());

	}
}
