package com.excilys.formation.bank.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

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
	private Date dateInit;

	@Column(name = "date_valid")
	private Date dateValid;

	@Column(name = "etat")
	@Type(type = "com.excilys.formation.bank.bean.StringEnumPersistenceType", parameters = {
			@Parameter(name = "enumClass", value = "com.excilys.formation.bank.bean.Etat"),

			@Parameter(name = "identifierMethod", value = "getEtat"),

			@Parameter(name = "valueOfMethod", value = "valueByString") })
	private Etat etat;

	@Column
	private String libelle;

	@ManyToOne
	@JoinColumn(name = "transaction_categorie_id")
	private TransactionCategorie transactionCategorie;

	public final Date getDateInit() {
		return dateInit;
	}

	public final Date getDateValid() {
		return dateValid;
	}

	public final Etat getEtat() {
		return etat;
	}

	public final Integer getTransactionId() {
		return transactionId;
	}

	public final void setDateInit(Date dateInit) {
		this.dateInit = dateInit;
	}

	public final void setDateValid(Date dateValid) {
		this.dateValid = dateValid;
	}

	public final void setEtat(Etat etat) {
		this.etat = etat;
	}

	public final void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
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

	public TransactionCategorie getTransactionCategorie() {
		return transactionCategorie;
	}

	public void setTransactionCategorie(
			TransactionCategorie transactionCategorie) {
		this.transactionCategorie = transactionCategorie;
	}

}
