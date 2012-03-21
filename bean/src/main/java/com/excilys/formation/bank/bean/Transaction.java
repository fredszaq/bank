package com.excilys.formation.bank.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Transaction implements Serializable {

	public enum Etat {
		VALIDATED, WAITING;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7809510233884919283L;

	@Id
	@GeneratedValue
	@Column(name = "transaction_id")
	private String transactionId;

	@Column(name = "date_init")
	private Timestamp dateInit;

	@Column(name = "date_valid")
	private Timestamp dateValid;

	@Column(name = "etat_id")
	@Enumerated(EnumType.STRING)
	private Etat etat;

	public final Timestamp getDateInit() {
		return dateInit;
	}

	public final Timestamp getDateValid() {
		return dateValid;
	}

	public final Etat getEtat() {
		return etat;
	}

	public final String getTransactionId() {
		return transactionId;
	}

	public final void setDateInit(Timestamp dateInit) {
		this.dateInit = dateInit;
	}

	public final void setDateValid(Timestamp dateValid) {
		this.dateValid = dateValid;
	}

	public final void setEtat(Etat etat) {
		this.etat = etat;
	}

	public final void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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
