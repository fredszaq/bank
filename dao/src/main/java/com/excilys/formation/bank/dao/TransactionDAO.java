package com.excilys.formation.bank.dao;

import com.excilys.formation.bank.bean.Transaction;

/**
 * 
 * @author excilys
 * 
 */
public interface TransactionDAO {

	boolean delete(Transaction transaction);

	boolean insert(Transaction transaction);

	boolean update(Transaction transaction);

}
