package com.excilys.formation.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class used for test purposes.
 * 
 * TODO delete this ;D
 * 
 * @author excilys
 * 
 */
public class Main {

	/**
	 * @param args
	 *            cli arguments
	 */
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(Main.class);
		logger.debug("test");
	}

	/**
	 * private contructor to prevent the instanciation of an object of this
	 * type.
	 */
	private Main() {
		// nothing here
	}
}
