package com.excilys.formation.bank.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_categories")
public class TransactionCategorie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6360299831361322000L;

	public enum TransactionCategorieType {
		CARTE, VIREMENT_INTERNE, VIREMENT_EXTERNE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_categorie_id")
	private Integer transactionCategorie;

	@Column(name = "transaction_categorie")
	@Enumerated(EnumType.STRING)
	private TransactionCategorieType transactionCategorieType;

	public final Integer getTransactionCategorie() {
		return transactionCategorie;
	}

	public final void setTransactionCategorie(Integer transactionCategorie) {
		this.transactionCategorie = transactionCategorie;
	}

	public final TransactionCategorieType getTransactionCategorieType() {
		return transactionCategorieType;
	}

	public final void setTransactionCategorieType(
			TransactionCategorieType transactionCategorieType) {
		this.transactionCategorieType = transactionCategorieType;
	}

	@Override
	public final String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransactionCategorie [transactionCategorie=")
				.append(transactionCategorie)
				.append(", transactionCategorieType=")
				.append(transactionCategorieType).append("]");
		return builder.toString();
	}

}
