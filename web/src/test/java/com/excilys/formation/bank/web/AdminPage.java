package com.excilys.formation.bank.web;

import static org.fest.assertions.Assertions.assertThat;

/**
 * This class uses the PageObject pattern and describes the main admin page of
 * the application.
 * 
 * @author excilys
 * 
 */
public class AdminPage extends BankRootPage {

	@Override
	public final String getUrl() {
		return TestConstants.BASE_URL + "secure/admin/admin.html";
	}

	@Override
	public final void isAt() {
		assertThat(find("#adminContent")).hasSize(1);
	}

}
