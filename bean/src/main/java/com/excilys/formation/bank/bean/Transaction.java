package com.excilys.formation.bank.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * Transaction bean.
 * 
 * @author excilys
 * 
 */
@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7809510233884919283L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private Integer transactionId;

	@Column(name = "date_init")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dateInit;

	@Column(name = "date_valid")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dateValid;

	@Column(name = "etat")
	@Type(type = "com.excilys.formation.bank.bean.StringEnumPersistenceType", parameters = {
			@Parameter(name = "enumClass", value = "com.excilys.formation.bank.bean.Etat"),

			@Parameter(name = "identifierMethod", value = "getEtat"),

			@Parameter(name = "valueOfMethod", value = "valueByString") })
	private Etat etat;

	@Column
	private String libelle;

	@Column(name = "transaction_categorie")
	@Type(type = "com.excilys.formation.bank.bean.StringEnumPersistenceType", parameters = {
			@Parameter(name = "enumClass", value = "com.excilys.formation.bank.bean.TransactionCategorie"),

			@Parameter(name = "identifierMethod", value = "getTransactionCategorie"),

			@Parameter(name = "valueOfMethod", value = "valueByString") })
	private TransactionCategorie transactionCategorie;

	public final DateTime getDateInit() {
		return dateInit;
	}

	public final DateTime getDateValid() {
		return dateValid;
	}

	public final Etat getEtat() {
		return etat;
	}

	public final Integer getTransactionId() {
		return transactionId;
	}

	public final void setDateInit(DateTime dateInit) {
		this.dateInit = dateInit;
	}

	public final void setDateValid(DateTime dateValid) {
		this.dateValid = dateValid;
	}

	public final void setEtat(Etat etat) {
		this.etat = etat;
	}

	public final void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public final String getLibelle() {
		return libelle;
	}

	public final void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public final String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction [transactionId=").append(transactionId)
				.append(", dateInit=").append(dateInit).append(", dateValid=")
				.append(dateValid).append("]");
		return builder.toString();
	}

	public final TransactionCategorie getTransactionCategorie() {
		return transactionCategorie;
	}

	public final void setTransactionCategorie(
			TransactionCategorie transactionCategorie) {
		this.transactionCategorie = transactionCategorie;
	}

}
