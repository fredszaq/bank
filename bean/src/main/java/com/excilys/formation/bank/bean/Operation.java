package com.excilys.formation.bank.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operations")
public class Operation {

	@ManyToOne
	@JoinColumn(name = "operation_type_id")
	private OperationType operationType;

	@Column
	private Double montant;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "operation_id")
	private Integer operationId;

	@ManyToOne
	@JoinColumn(name = "transaction_id")
	private Transaction transaction;

	public Double getMontant() {
		return this.montant;
	}

	public Integer getOperationId() {
		return this.operationId;
	}

	public OperationType getOperationType() {
		return this.operationType;
	}

	public Transaction getTransaction() {
		return this.transaction;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public void setOperationId(Integer operationId) {
		this.operationId = operationId;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}