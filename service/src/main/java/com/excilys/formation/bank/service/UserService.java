package com.excilys.formation.bank.service;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.bean.User;

@Transactional
public interface UserService extends UserDetailsService {

	@Transactional(readOnly = true)
	Set<Compte> getComptesByUsername(String login)
			throws UsernameNotFoundException;

	@Override
	@Transactional(readOnly = true)
	User loadUserByUsername(String login) throws UsernameNotFoundException;
}
