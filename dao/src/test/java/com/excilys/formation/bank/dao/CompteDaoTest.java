package com.excilys.formation.bank.dao;

import static org.fest.assertions.Assertions.assertThat;

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
import com.excilys.formation.bank.exception.CompteNotFoundException;

/**
 * Test pour la classe CompteDAO.
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
@DataSet("/datasets/dataSetCompteDao.xml")
@Transactional
@TransactionConfiguration
public class CompteDaoTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private CompteDAO compteDAO;

	/**
	 * Test load Compte by Username and CompteId.
	 */
	@Test
	public final void loadCompteByUsernameAndCompteId()
			throws CompteNotFoundException {
		assertThat(
				compteDAO.getCompteByUsernameAndCompteId("testUser1",
						"compte1user1")).isEqualTo(
				compteDAO.getCompteById("compte1user1"));
	}

	/**
	 * Test load Compte by Username and CompteId when the User does not own the
	 * Compte.
	 */
	@Test(expected = CompteNotFoundException.class)
	public final void loadCompteByUsernameAndCompteIdWhenTheUserDoesNotOwnTheCompte()
			throws CompteNotFoundException {
		assertThat(compteDAO.getCompteById("compte1user2")).isNotNull();
		assertThat(
				compteDAO.getCompteByUsernameAndCompteId("testUser1",
						"compte1user2")).isNull();
	}

	/**
	 * Test update Compte enlever argent.
	 */
	@Test
	public final void updateCompteEnleverArgent()
			throws CompteNotFoundException {
		long soldeInitial = compteDAO.getCompteById("compte1user1").getSolde();
		compteDAO.updateSolde("compte1user1", -20);
		assertThat(compteDAO.getCompteById("compte1user1").getSolde())
				.isEqualTo(soldeInitial - 20);
	}

	/**
	 * Test update Compte ajouter argent.
	 */
	@Test
	public final void updateCompteAjouterArgent()
			throws CompteNotFoundException {
		long soldeInitial = compteDAO.getCompteById("compte1user1").getSolde();
		compteDAO.updateSolde("compte1user1", 20);
		assertThat(compteDAO.getCompteById("compte1user1").getSolde())
				.isEqualTo(soldeInitial + 20);
	}
}
