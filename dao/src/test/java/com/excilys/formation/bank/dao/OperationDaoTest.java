package com.excilys.formation.bank.dao;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Interval;
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
import com.excilys.formation.bank.bean.Operation;
import com.excilys.formation.bank.bean.OperationType;
import com.excilys.formation.bank.exception.OperationNotFoundException;

/**
 * Test de la classe Operation DAO.
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
public class OperationDaoTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private OperationDAO operationDAO;

	private Operation operationDebit;

	private Operation operationCredit;

	private DateTime dateDebut;

	private DateTime dateFin;

	/**
	 * Méthode d'initialisation avant chaque test.
	 */
	@Transactional(readOnly = true)
	@Before
	public final void init() throws OperationNotFoundException {
		operationDebit = operationDAO.getOperationById(1);
		operationCredit = operationDAO.getOperationById(2);
		dateDebut = new DateTime().withDate(2009, 9, 10);
		dateFin = dateDebut.plusYears(4);

	}

	/**
	 * Test obtention d'une operation de type débit.
	 */
	@Test
	public final void getOperationDebitTest() {
		assertThat(operationDebit.getMontant()).isEqualTo(42);
		assertThat(operationDebit.getOperationType()).isEqualTo(
				OperationType.DEBIT);
	}

	/**
	 * Test obtention d'une operation de type crédit.
	 */
	@Test
	public final void getOperationCreditTest() {
		assertThat(operationCredit.getMontant()).isEqualTo(42);
		assertThat(operationCredit.getOperationType()).isEqualTo(
				OperationType.CREDIT);
	}

	/**
	 * Test d'insertion d'une opération.
	 */
	@Test
	public final void insertOperation() throws OperationNotFoundException {
		Operation operationCarte = new Operation();
		operationCarte.setMontant(3400);
		operationCarte.setOperationId(3);
		operationCarte.setOperationType(OperationType.DEBIT);

		operationDAO.insert(operationCarte);
		assertThat(operationDAO.getOperationById(5)).isEqualTo(operationCarte);
	}

	/**
	 * Test de mise à jour d'une opération.
	 */
	@Test
	public final void updateOperation() throws OperationNotFoundException {
		operationCredit.setMontant(5700);
		operationDAO.update(operationCredit);
		assertThat(operationDAO.getOperationById(2).getMontant()).isEqualTo(
				5700);
	}

	/**
	 * Test d'obtention des opérations carte pour un compte donné.
	 */
	@Test
	public final void getOperationCarteFromCompteId() {
		Interval interval = new Interval(dateDebut, dateFin);
		List<Operation> operations = operationDAO
				.searchOperationCarteFromCompteId("compte1", interval);
		assertThat(operations).hasSize(1);
		assertThat(operations.get(0).getMontant()).isEqualTo(444);
	}

	/**
	 * Test d'obtention des opérations carte pour un compte donné quand il n'y a
	 * pas d'opérations carte existante.
	 */
	@Test
	public final void getOperationCarteFromCompteIdWhenThereAreNoCarteOperations() {
		Interval interval = new Interval(dateDebut, dateFin);
		List<Operation> operations = operationDAO
				.searchOperationCarteFromCompteId("compte2", interval);
		assertThat(operations).isEmpty();
	}

	/**
	 * Test d'obtention du total des opérations carte.
	 */
	@Test
	public final void getTotalOperationCarteFromCompteId() {
		DateTime debut = new DateTime(2010, 9, 1, 0, 0);
		DateTime fin = new DateTime(2010, 10, 1, 0, 0);
		Interval interval = new Interval(debut, fin);
		assertThat(
				operationDAO.searchTotalOperationCarteFromCompteId("compte1",
						interval)).isEqualTo(444);

	}

	/**
	 * Test d'obtention du total des opérations carte quand il n'y en a pas.
	 */
	@Test
	public final void getTotalOperationCarteFromCompteIdWhenThereAreNoCarteOperations() {
		DateTime debut = new DateTime(2010, 9, 1, 0, 0);
		DateTime fin = new DateTime(2010, 10, 1, 0, 0);
		Interval interval = new Interval(debut, fin);
		assertThat(
				operationDAO.searchTotalOperationCarteFromCompteId("compte2",
						interval)).isEqualTo(0);

	}

	/**
	 * Test d'obtention des opérations non carte.
	 */
	@Test
	public final void getOperationNonCarteFromCompteId() {
		Interval interval = new Interval(dateDebut, dateFin);
		List<Operation> operations = operationDAO
				.searchOperationNonCarteFromCompteId("compte1", interval);
		assertThat(operations).hasSize(1);
		assertThat(operations.get(0).getMontant()).isEqualTo(42);
	}

	/**
	 * Test d'obtention du total des opérations en attente.
	 */
	@Test
	public final void getTotalOperationsNonValideesFromCompteId() {
		assertThat(
				operationDAO
						.searchTotalOperationsNonValideesFromCompteId("compte1"))
				.isEqualTo(555);

	}

	/**
	 * Test d'obtention du total des opérations carte quand il n'y en a pas.
	 */
	@Test
	public final void getTotalOperationsNonValideesFromCompteIdWhenThereAreNoCarteOperations() {
		assertThat(
				operationDAO
						.searchTotalOperationsNonValideesFromCompteId("compte2"))
				.isEqualTo(0);

	}
}
