package com.excilys.formation.bank.service;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.DataSetTestExecutionListener;
import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.bean.CompteType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:context/applicationContext*.xml",
		"classpath:contextTest/applicationContext-serviceTest.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DataSetTestExecutionListener.class })
@DataSet("/datasets/dataSetService.xml")
public class TestUserService {
	@Autowired
	private UserService userService;

	@Test
	public void testGetCompteByUsernameAndAccountIdWhenTheUserDoesNotOwnsTheCompte() {
		Compte compte = userService.getCompteByUsernameAndAccountId("user2",
				"compte1");
		assertThat(compte).isNull();
	}

	@Test
	public void testGetCompteByUsernameAndAccountIdWhenTheUserOwnsTheCompte() {
		Compte compte = userService.getCompteByUsernameAndAccountId("user2",
				"compte3");
		assertThat(compte.getCompteId()).isEqualTo("compte3");
		assertThat(compte.getCompteType()).isEqualTo(CompteType.COURANT);
		assertThat(compte.getSolde()).isEqualTo(150);
	}
}
