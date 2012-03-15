package com.excilys.formation.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.excilys.formation.bank.bean.User;
import com.excilys.formation.bank.dao.UserDAO;
import com.excilys.formation.bank.dao.exception.UsernameNotFoundException;
import com.excilys.formation.bank.service.UserService;

@Service("userService")
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public UserServiceImpl(){
		
	}

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.userDAO.loadUserByUsername(username);
	}

}
