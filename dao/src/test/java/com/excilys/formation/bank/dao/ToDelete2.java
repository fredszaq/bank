package com.excilys.formation.bank.dao;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:context/applicationContext*.xml",
		"classpath*:contextTest/applicationContext*.xml" })
public class ToDelete2 {
	@Test
	public void essaiTest() {
		assertThat(true);
	}
}
