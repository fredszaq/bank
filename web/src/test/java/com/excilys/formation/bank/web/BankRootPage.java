package com.excilys.formation.bank.web;

import static org.fest.assertions.Assertions.assertThat;

import org.fluentlenium.core.FluentPage;

/**
 * This class uses the PageObject pattern and describes the main page of the
 * application.
 * 
 * @author excilys
 * 
 */
public class BankRootPage extends FluentPage {

	/**
	 * Checks with assertions that the page is showing errors.
	 */
	public final void isShowingErrors() {
		assertThat(find(".error")).isNotEmpty();
	}

}
