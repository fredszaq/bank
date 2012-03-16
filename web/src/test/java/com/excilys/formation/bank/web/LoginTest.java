package com.excilys.formation.bank.web;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

/**
 * 
 * @author excilys
 * 
 */
public class LoginTest extends FluentTest {

	@Page
	public LoginPage loginPage;

	/**
	 * A very rigorous test.
	 */
	@Test
	public final void goToLogin() {
		goTo(this.loginPage);
		this.loginPage.isAt();
	}
}
