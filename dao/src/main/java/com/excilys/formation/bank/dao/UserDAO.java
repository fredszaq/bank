package com.excilys.formation.bank.dao;

import com.excilys.formation.bank.bean.User;
import com.excilys.formation.bank.dao.exception.UsernameNotFoundException;

public interface UserDAO {
	User loadUserByUsername(String username) throws UsernameNotFoundException;
}
