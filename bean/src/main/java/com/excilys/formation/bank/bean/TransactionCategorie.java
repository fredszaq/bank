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

/**
 * Enum TransactionCategorie.
 * 
 * @author excilys
 * 
 */
@Entity
@Table(name = "transaction_categories")
public enum TransactionCategorie implements Serializable {
	CARTE("CARTE"), VIREMENT_INTERNE("VIREMENT_INTERNE"), VIREMENT_EXTERNE(
			"VIREMENT_EXTERNE");
	@Id
	@Generated("assigned")
	@Column(name = "transaction_categorie")
	private final String transactionCategorie;

	private static final Map<String, TransactionCategorie> ID_MAP = new HashMap<String, TransactionCategorie>();

	static {
		for (TransactionCategorie categorie : EnumSet
				.allOf(TransactionCategorie.class)) {
			ID_MAP.put(categorie.getTransactionCategorie(), categorie);
		}
	}

	/**
	 * Constructeur logique.
	 * 
	 * @param categorie
	 *            : la categorie de la transaction
	 */
	private TransactionCategorie(final String categorie) {
		transactionCategorie = categorie;
	}

	public String getTransactionCategorie() {
		return transactionCategorie;
	}

	/**
	 * Retourne la TransactionCategorie en fonction de son nom.
	 * 
	 * @param categorie
	 *            : la catégorie de la transaction
	 * @return TransactionCategorie
	 */
	public static TransactionCategorie valueByString(String categorie) {
		return ID_MAP.get(categorie);
	}
}
