package com.excilys.formation.bank.dao;

import com.excilys.formation.bank.bean.OperationComptable;
import com.excilys.formation.bank.bean.OperationComptable.OperationComptableType;

public interface OperationComptableDAO {
	OperationComptable getOperationComptableByType(
			OperationComptableType operationComptableType);
}
