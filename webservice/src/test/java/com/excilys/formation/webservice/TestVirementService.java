package com.excilys.formation.webservice;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath*:contextTest/applicationContext-*.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class TestVirementService {

	@Autowired
	private VirementServiceWs virementServiceWs;

	@Test
	public void simpleTest() {
		assertThat(virementServiceWs).isNotNull();
	}

	/*
	 * @Test(expected = Exception.class) public final void
	 * creationVirementMontantNegatifTest() {
	 * virementServiceWs.createVirement("user1", "compte1", "compte3", -100,
	 * "marche pas"); }
	 * 
	 * @Test(expected = Exception.class) public final void
	 * creationVirement2ComptesPareil() {
	 * virementServiceWs.createVirement("user1", "compte1", "compte1", 100,
	 * "marche pas"); }
	 * 
	 * @Test(expected = Exception.class) public final void
	 * creationVirementCompteNApartenantPasALUser() {
	 * virementServiceWs.createVirement("user2", "compte1", "compte2", 100,
	 * "marche pas"); }
	 */
}
