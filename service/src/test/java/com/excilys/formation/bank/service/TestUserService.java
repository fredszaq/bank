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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:context/applicationContext*.xml",
		"classpath*:contextTest/applicationContext*.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DataSetTestExecutionListener.class })
@DataSet("/datasets/dataSetUserService.xml")
public class TestUserService {
	@Autowired
	private UserService userService;

	@Test
	public void testGetCompteByUsernameAndAccountIdWhenTheUserDoesNotOwnsTheCompte() {
		Compte compte = userService.getCompteByUsernameAndAccountId(
				"testUser2", "compte1user1");
		assertThat(compte).isNull();
	}

	@Test
	public void testGetCompteByUsernameAndAccountIdWhenTheUserOwnsTheCompte() {
		Compte compte = userService.getCompteByUsernameAndAccountId(
				"testUser2", "compte1user2");
		assertThat(compte.getCompteId()).isEqualTo("compte1user2");
		assertThat(compte.getCompteType()).isEqualTo(Compte.CompteType.COURANT);
		assertThat(compte.getSolde()).isEqualTo(3.14);
	}
}
