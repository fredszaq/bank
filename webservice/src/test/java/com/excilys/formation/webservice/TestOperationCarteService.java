package com.excilys.formation.webservice;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:context/applicationContext*.xml",
		"classpath*:contextTest/applicationContext-*.xml" })
public class TestOperationCarteService {
	@Autowired
	private VirementServiceWs virementServiceWs;

	@Test
	public void simpleTest() {
		assertThat(virementServiceWs).isNotNull();
	}
}
