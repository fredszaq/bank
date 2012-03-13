package com.excilys.formation.bank.bean;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

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
		Assert.assertEquals(1, 1);
	}

	/**
	 * Another very rigorous test.
	 */
	@Test
	public final void testSomeEntity() {
		SomeEntity entity = new SomeEntity();
		Date date = new Date();
		entity.setSomeDate(date);
		assertThat(entity.getSomeDate()).isEqualTo(date);
		entity.setSomeInteger(1);
		assertThat(entity.getSomeInteger()).isEqualTo(1);
		entity.setSomeString("hello");
		assertThat(entity.getSomeString()).isEqualTo("hello");
		entity.toString();
	}

}
