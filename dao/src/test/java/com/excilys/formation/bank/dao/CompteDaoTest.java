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

	@Test
	public final void loadCompteByUsernameAndCompteId() {
		assertThat(
				compteDAO.loadCompteByUsernameAndCompteId("testUser1",
						"compte1user1")).isEqualTo(
				compteDAO.loadCompteById("compte1user1"));
	}

	@Test
	public final void loadCompteByUsernameAndCompteIdWhenTheUserDoesNotOwnTheCompte() {
		assertThat(compteDAO.loadCompteById("compte1user2")).isNotNull();
		assertThat(
				compteDAO.loadCompteByUsernameAndCompteId("testUser1",
						"compte1user2")).isNull();
	}

	@Test
	public final void updateCompteEnleverArgent() {
		Double soldeInitial = compteDAO.loadCompteById("compte1user1")
				.getSolde();
		compteDAO.updateSolde("compte1user1", -20);
		assertThat(compteDAO.loadCompteById("compte1user1").getSolde())
				.isEqualTo(soldeInitial - 20);
	}

	@Test
	public final void updateCompteAjouterArgent() {
		Double soldeInitial = compteDAO.loadCompteById("compte1user1")
				.getSolde();
		compteDAO.updateSolde("compte1user1", 20);
		assertThat(compteDAO.loadCompteById("compte1user1").getSolde())
				.isEqualTo(soldeInitial + 20);
	}
}
