package com.excilys.formation.bank.web;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import com.excilys.formation.bank.web.controller.HomeController;

/**
 * 
 * @author excilys
 * 
 */
public class SimpleTest {
	/**
	 * A very rigorous test.
	 */
	@Test
	public final void oneEqualsOne() {
		assertThat(new HomeController().home()).isEqualTo("index");
	}
}