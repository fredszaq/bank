package com.excilys.formation.bank.dao;

import com.excilys.formation.bank.bean.TransactionCategorie;
import com.excilys.formation.bank.bean.TransactionCategorie.TransactionCategorieType;

public interface TransactionCategorieDAO {
	TransactionCategorie getTransactionCategorieByType(
			TransactionCategorieType categorieType);
}
