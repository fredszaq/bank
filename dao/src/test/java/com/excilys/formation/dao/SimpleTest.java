package com.excilys.formation.dao;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author excilys
 * 
 */
public class SimpleTest {

	/**
	 * A cobertura test.
	 */
	@Test
	public final void cobertura() {
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
}
