package com.excilys.formation.bank.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.excilys.formation.bank.bean.User;

@Transactional
public interface UserService extends UserDetailsService {

	@Transactional(rollbackFor = RuntimeException.class)
	void ajouter(User user);

	@Override
	@Transactional(readOnly = true)
	User loadUserByUsername(String username) throws UsernameNotFoundException;
}
