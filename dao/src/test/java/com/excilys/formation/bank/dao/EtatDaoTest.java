package com.excilys.formation.bank.dao;

import static org.fest.assertions.Assertions.assertThat;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:context/applicationContext*.xml",
		"classpath*:contextTest/applicationContext*.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DataSetTestExecutionListener.class })
@DataSet("/datasets/dataSetEtatDao.xml")
@Transactional
@TransactionConfiguration
public class EtatDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private EtatDAO etatDAO;

	private Etat etat;

	@Transactional(readOnly = true)
	@Before
	public void init() {
		etat = etatDAO.getEtatByType(EtatType.VALIDATED);
	}

	@Test
	public void getEtatByType() {
		assertThat(etat.getEtatType()).isEqualTo(EtatType.VALIDATED);
	}

	@After
	public void end() {
		etat = null;
		etatDAO = null;
	}
}
