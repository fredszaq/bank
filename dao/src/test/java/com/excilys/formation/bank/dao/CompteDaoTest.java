package com.excilys.formation.bank.dao;

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
@ContextConfiguration({ "classpath*:context/applicationContext*.xml",
		"classpath*:contextTest/applicationContext*.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DataSetTestExecutionListener.class })
@DataSet("/dataSetCompteDao.xml")
@Transactional
@TransactionConfiguration
public class CompteDaoTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private CompteDAO compteDAO;

	@Test
	public void testLoadCompteByUsernameAndAccountIdWhenTheUserDoesNotOwnsTheCompte() {
		// Compte compte =
		// compteDAO.loadCompteByUsernameAndAccountId("testUser2",
		// "compte1user1");
		// assertThat(compte).isNull();
	}

	@Test
	public void testLoadCompteByUsernameAndAccountIdWhenTheUserOwnsTheCompte() {
		// Compte compte =
		// compteDAO.loadCompteByUsernameAndAccountId("testUser2",
		// "compte1user2");
		// assertThat(compte.getCompteId()).isEqualTo("compte1user2");
		// assertThat(compte.getCompteType()).isEqualTo(Compte.CompteType.COURANT);
		// assertThat(compte.getSolde()).isEqualTo(3.14);
	}
}
