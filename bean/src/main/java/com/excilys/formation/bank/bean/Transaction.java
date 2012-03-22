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

	@ManyToOne
	@JoinColumn(name = "etat_id")
	private Etat etat;

	@Column
	private String libelle;

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

}
