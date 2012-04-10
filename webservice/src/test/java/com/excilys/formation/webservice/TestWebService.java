package com.excilys.formation.webservice;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.excilys.formation.bank.bean.TransactionCategorie;
import com.excilys.formation.dto.CompteDTO;
import com.excilys.formation.dto.TransactionDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:contextTest/applicationContext-*.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class TestWebService {

	@Autowired
	private VirementServiceWs virementServiceWs;

	@Autowired
	private UserServiceWs userServiceWs;

	@Test
	public void userServiceWsNotNullTest() {
		assertThat(userServiceWs).isNotNull();
	}

	@Test
	public void virementServiceWsNotNullTest() {
		assertThat(virementServiceWs).isNotNull();
	}

	@Test
	public void getCompteByLoginTest() {
		String login = "robert";
		Set<CompteDTO> comptesDTO = userServiceWs.getComptesByUsername(login);
		assertThat(comptesDTO.size()).isEqualTo(2);
	}

	@Test
	public final void creationVirementInterneTest() {
		double soldeInitialDebiteur = userServiceWs
				.getCompteByUsernameAndAccountId("robert",
						"compte_courant_robert").getSolde();
		double soldeInitialCrediteur = userServiceWs
				.getCompteByUsernameAndAccountId("robert",
						"compte_epargne_robert").getSolde();
		DateTime now = DateTime.now();
		TransactionDTO transactionDTO = virementServiceWs.createVirement(
				"robert", "compte_courant_robert", "compte_epargne_robert", 35,
				"oh le beau virement");

		assertThat(transactionDTO.getLibelle())
				.isEqualTo("oh le beau virement");

		// VÉRIFICATION DE LA DATE INITIALE DE TRANSACTION
		transactionDTO.getDateInit();
		DateTime dateTransactionInit = new DateTime(
				transactionDTO.getDateInit());
		assertThat(Days.daysBetween(now, dateTransactionInit).getDays())
				.isEqualTo(0);

		// VÉRIFICATION DE LA DATE FINALE DE TRANSACTION
		DateTime dateTransactionValid = new DateTime(
				transactionDTO.getDateValid());
		assertThat(Days.daysBetween(now, dateTransactionValid).getDays())
				.isEqualTo(0);

		// SOLDES FINAUX
		double soldeFinalDebiteur = userServiceWs
				.getCompteByUsernameAndAccountId("robert",
						"compte_courant_robert").getSolde();
		double soldeFinalCrediteur = userServiceWs
				.getCompteByUsernameAndAccountId("robert",
						"compte_epargne_robert").getSolde();
		assertThat(soldeFinalDebiteur).isEqualTo(soldeInitialDebiteur - 35);
		assertThat(soldeFinalCrediteur).isEqualTo(soldeInitialCrediteur + 35);

		// VIREMENT INTERNE
		assertThat(transactionDTO.getTransactionCategorie()).isEqualTo(
				TransactionCategorie.VIREMENT_INTERNE);
	}
}
