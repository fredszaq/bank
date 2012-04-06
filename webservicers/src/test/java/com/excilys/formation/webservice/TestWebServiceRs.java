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
import com.excilys.formation.webservicers.UserServiceRs;
import com.excilys.formation.webservicers.VirementServiceRs;
import com.excilys.formation.webservicers.dto.bean.CompteDTO;
import com.excilys.formation.webservicers.dto.bean.TransactionDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:contextTest/applicationContext-*.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class TestWebServiceRs {

	@Autowired
	private VirementServiceRs virementServiceRs;

	@Autowired
	private UserServiceRs userServiceRs;

	@Test
	public void userServiceWsNotNullTest() {
		assertThat(userServiceRs).isNotNull();
	}

	@Test
	public void virementServiceWsNotNullTest() {
		assertThat(virementServiceRs).isNotNull();
	}

	@Test
	public void getCompteByLoginTest() {
		String login = "robert";
		Set<CompteDTO> comptesDTO = userServiceRs.getComptesByUsername(login);
		assertThat(comptesDTO.size()).isEqualTo(2);
	}

	@Test
	public final void creationVirementInterneTest() {
		double soldeInitialDebiteur = userServiceRs
				.getCompteByUsernameAndAccountId("robert",
						"compte_courant_robert").getSolde();
		double soldeInitialCrediteur = userServiceRs
				.getCompteByUsernameAndAccountId("robert",
						"compte_epargne_robert").getSolde();
		DateTime now = DateTime.now();
		TransactionDTO transactionDTO = virementServiceRs.createVirement(
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
		double soldeFinalDebiteur = userServiceRs
				.getCompteByUsernameAndAccountId("robert",
						"compte_courant_robert").getSolde();
		double soldeFinalCrediteur = userServiceRs
				.getCompteByUsernameAndAccountId("robert",
						"compte_epargne_robert").getSolde();
		assertThat(soldeFinalDebiteur).isEqualTo(soldeInitialDebiteur - 35);
		assertThat(soldeFinalCrediteur).isEqualTo(soldeInitialCrediteur + 35);

		// VIREMENT INTERNE
		assertThat(transactionDTO.getTransactionCategorie()).isEqualTo(
				TransactionCategorie.VIREMENT_INTERNE);
	}
}
