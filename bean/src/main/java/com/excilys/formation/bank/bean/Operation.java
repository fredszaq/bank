package com.excilys.formation.bank.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

/**
 * Bean Operation.
 * 
 * @author excilys
 * 
 */
@Entity
@Table(name = "operations")
public class Operation {

	@Column(name = "operation_type")
	@Type(type = "com.excilys.formation.bank.bean.StringEnumPersistenceType", parameters = {
			@Parameter(name = "enumClass", value = "com.excilys.formation.bank.bean.OperationType"),

			@Parameter(name = "identifierMethod", value = "getOperationType"),

			@Parameter(name = "valueOfMethod", value = "valueByString") })
	private OperationType operationType;

	@Column
	private Double montant;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "operation_id")
	private Integer operationId;

	@ManyToOne
	@JoinTable(name = "comptes_operations", joinColumns = @JoinColumn(name = "operation_id"), inverseJoinColumns = @JoinColumn(name = "compte_id"))
	private Compte compte;

	@Override
	public final String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Operation [montant=").append(montant)
				.append(", operationId=").append(operationId)
				.append(", transaction=").append(transaction).append("]");
		return builder.toString();
	}

	@ManyToOne
	@JoinColumn(name = "transaction_id")
	private Transaction transaction;

	public final Double getMontant() {
		return montant;
	}

	public final OperationType getOperationType() {
		return operationType;
	}

	public final void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public final Integer getOperationId() {
		return operationId;
	}

	public final Transaction getTransaction() {
		return transaction;
	}

	public final void setMontant(Double montant) {
		this.montant = montant;
	}

	public final void setOperationId(Integer operationId) {
		this.operationId = operationId;
	}

	public final void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public final Compte getCompte() {
		return compte;
	}

	public final void setCompte(Compte compte) {
		this.compte = compte;
	}

}