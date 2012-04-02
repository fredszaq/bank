package com.excilys.formation.bank.bean;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_categories")
public enum TransactionCategorie implements Serializable {
	CARTE("CARTE"), VIREMENT_INTERNE("VIREMENT_INTERNE"), VIREMENT_EXTERNE(
			"VIREMENT_EXTERNE");
	@Id
	@Generated("assigned")
	@Column(name = "transaction_categorie")
	private final String transactionCategorie;

	private static final Map<String, TransactionCategorie> idMap = new HashMap<String, TransactionCategorie>();

	static {
		for (TransactionCategorie categorie : EnumSet
				.allOf(TransactionCategorie.class)) {
			idMap.put(categorie.getTransactionCategorie(), categorie);
		}
	}

	private TransactionCategorie(final String categorie) {
		transactionCategorie = categorie;
	}

	public String getTransactionCategorie() {
		return transactionCategorie;
	}

	public static TransactionCategorie valueByString(String categorie) {
		return idMap.get(categorie);
	}
}
