package com.excilys.formation.bank.dao.exception;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UsernameNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4960794745590976979L;

	public UsernameNotFoundException() {
		super();
	}

	public UsernameNotFoundException(String msg, Throwable exc) {
		super(msg, exc);
	}

	public UsernameNotFoundException(String msg) {
		super(msg);
	}

	public UsernameNotFoundException(Throwable exc) {
		super(exc);
	}

	
	
}
