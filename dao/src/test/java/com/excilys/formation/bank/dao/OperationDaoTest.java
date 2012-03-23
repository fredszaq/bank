package com.excilys.formation.bank.dao;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

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
import com.excilys.formation.bank.bean.Operation;
import com.excilys.formation.bank.bean.OperationComptable;
import com.excilys.formation.bank.bean.OperationComptable.OperationComptableType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:context/applicationContext*.xml",
		"classpath*:contextTest/applicationContext*.xml" })
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

	@Transactional(readOnly = true)
	@Before
	public final void init() {
		operationDebit = operationDAO.getOperationById(1);
		operationCredit = operationDAO.getOperationById(2);

	}

	@Test
	public final void getOperationDebitTest() {
		assertThat(operationDebit.getMontant()).isEqualTo(42);
		assertThat(
				operationDebit.getOperationComptable()
						.getOperationComptableType()).isEqualTo(
				OperationComptableType.DEBIT);
	}

	@Test
	public final void getOperationCreditTest() {
		assertThat(operationCredit.getMontant()).isEqualTo(42);
		assertThat(
				operationCredit.getOperationComptable()
						.getOperationComptableType()).isEqualTo(
				OperationComptableType.CREDIT);
	}

	@Test
	public final void insertOperation() {
		Operation operationCarte = new Operation();
		operationCarte.setMontant(34.0);
		operationCarte.setOperationId(3);
		OperationComptable operationComptable = new OperationComptable();
		operationComptable
				.setOperationComptableType(OperationComptableType.DEBIT);
		operationCarte.setOperationType(operationComptable);

		operationDAO.insert(operationCarte);
		assertThat(operationDAO.getOperationById(5)).isEqualTo(operationCarte);
	}

	@Test
	public final void updateOperation() {
		operationCredit.setMontant(57.0);
		operationDAO.update(operationCredit);
		assertThat(operationDAO.getOperationById(2).getMontant()).isEqualTo(
				57.0);
	}

	@Test
	public final void deleteOperation() {
		operationDAO.delete(operationCredit);
		operationCredit = operationDAO.getOperationById(2);
		assertThat(operationCredit).isNull();
	}

	@Test
	public final void getOperationCarteFromCompteId() {
		List<Operation> operations = operationDAO
				.getOperationCarteFromCompteId("compte1");
		assertThat(operations).hasSize(2);
		assertThat(operations.get(0).getMontant()).isEqualTo(444);
		assertThat(operations.get(1).getMontant()).isEqualTo(555);
	}

	@Test
	public final void getOperationCarteFromCompteIdWhenThereAreNoCarteOperations() {
		List<Operation> operations = operationDAO
				.getOperationCarteFromCompteId("compte2");
		assertThat(operations).isEmpty();
	}

	@Test
	public final void getTotalOperationCarteFromCompteId() {
		assertThat(operationDAO.getTotalOperationCarteFromCompteId("compte1"))
				.isEqualTo(999);

	}

	@Test
	public final void getTotalOperationCarteFromCompteIdWhenThereAreNoCarteOperations() {
		assertThat(operationDAO.getTotalOperationCarteFromCompteId("compte2"))
				.isEqualTo(0);

	}

	@Test
	public final void getOperationNonCarteFromCompteId() {
		List<Operation> operations = operationDAO
				.getOperationNonCarteFromCompteId("compte1");
		assertThat(operations).hasSize(1);
		assertThat(operations.get(0).getMontant()).isEqualTo(42);
	}

	@After
	public final void end() {
		operationCredit = null;
		operationDebit = null;
		operationDAO = null;
	}
}
