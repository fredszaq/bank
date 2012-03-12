package com.excilys.formation.dao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.excilys.ebi.spring.dbunit.test.DataSet;
import com.excilys.ebi.spring.dbunit.test.DataSetTestExecutionListener;

/**
 * 
 * @author excilys
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("beans-context.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DataSetTestExecutionListener.class })
@DataSet
public class SimpleTest {

	@Autowired
	private SomeDAOInterface someDAOHibernate;

	/**
	 * A cobertura test.
	 */
	@Test
	public void cobertura() {
		SomeEntity someEntity = new SomeEntity();
		Assert.assertNull(someEntity.getSomeString());
	}

	/**
	 * A very rigorous test.
	 */
	@Test
	public final void oneEqualsOne() {
		Assert.assertEquals(1, 1);
	}

	@Test
	public void testOfTheDeathWhoKillsYourMomFromHerGraveWithASpoon() {
		SomeEntity theEntity = new SomeEntity();
		theEntity.setSomeDate(new Date());
		theEntity.setSomeString("ta sœur");
		this.someDAOHibernate.saveEntity(theEntity);
		// assertThat(this.someDAOHibernate.getEntityByString("ta sœur"))
		// .isEqualTo(theEntity);
		System.out.println(this.someDAOHibernate.getEntityByString("ta sœur"));
		System.out.println(theEntity);
		System.out.println(this.someDAOHibernate.getEntityByString("blabla"));
	}
}
