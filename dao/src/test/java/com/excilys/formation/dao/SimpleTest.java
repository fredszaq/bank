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
	 * A very rigorous test.
	 */
	@Test
	public void oneEqualsOne() {
		Assert.assertEquals(1, 1);
	}
	
	/**
	 * A cobertura test.
	 */
	@Test
	public void cobertura() {
		SomeEntity someEntity = new SomeEntity();
		Assert.assertNull(someEntity.getSomeString());
	}
}
