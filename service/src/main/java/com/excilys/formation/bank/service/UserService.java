package com.excilys.formation.bank.service;

import com.excilys.formation.bank.bean.User;
import com.excilys.formation.bank.dao.exception.UsernameNotFoundException;

public interface UserService {
	User loadUserByUsername(String username) throws UsernameNotFoundException;
}
