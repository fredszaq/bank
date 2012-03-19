package com.excilys.formation.bank.dao;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.excilys.formation.bank.bean.User;

public interface UserDAO {

	User loadUserByUsername(String login) throws UsernameNotFoundException;
}
