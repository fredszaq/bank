package com.excilys.formation.bank.service;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:context/applicationContext*.xml",
		"classpath*:contextTest/applicationContext*.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DataSetTestExecutionListener.class })
@DataSet("/datasets/dataSetService.xml")
public class TestEtatService {

	@Autowired
	// private EtatService etatService;
	private Etat etat;

	@Before
	public final void init() {
		// etat = etatService.getEtatByType(EtatType.VALIDATED);
	}

	@Test
	public final void getEtatByTypeTest() {
		// assertThat(etat.getEtatType()).isEqualTo(EtatType.VALIDATED);
	}

	@After
	public final void end() {
		// etat = null;
		// etatService = null;
	}
}
