package com.excilys.formation.bank.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.excilys.formation.bank.bean.User;

public interface UserService {
	User loadUserByUsername(String username) throws UsernameNotFoundException;
}
