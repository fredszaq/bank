package com.excilys.formation.bank.dao;

import com.excilys.formation.bank.bean.Compte;

public interface CompteDAO {

	Compte loadCompteById(String id);
}
