package com.excilys.formation.bank.bean;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Compte bean.
 * 
 * @author excilys
 * 
 */
@Entity
@Table(name = "comptes")
public class Compte implements Serializable, Comparable<Compte> {

	/**
	 * CompteType enum.
	 * 
	 * @author excilys
	 * 
	 */
	public enum CompteType {
		EPARGNE, COURANT;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8546946063789928623L;

	@Enumerated(EnumType.STRING)
	@Column(name = "compte_type")
	private CompteType compteType;

	@Column
	private Double solde;

	@Column(name = "taux_interet")
	private Double tauxInteret;

	@Column(name = "num_carte")
	private String numCarte;

	@Id
	@Generated("assigned")
	@Column(name = "compte_id")
	private String compteId;

	@ManyToMany
	@JoinTable(name = "users_comptes", joinColumns = @JoinColumn(name = "compte_id"), inverseJoinColumns = @JoinColumn(name = "login"))
	private Set<User> users;

	@OneToMany
	@JoinTable(name = "comptes_operations", joinColumns = @JoinColumn(name = "compte_id"), inverseJoinColumns = @JoinColumn(name = "operation_id"))
	private Set<Operation> operations;

	@Override
	public final int compareTo(Compte compte) {
		return getCompteId().compareTo(compte.getCompteId());
	}

	public final String getCompteId() {
		return compteId;
	}

	public final CompteType getCompteType() {
		return compteType;
	}

	public String getNumCarte() {
		return numCarte;
	}

	public final Double getSolde() {
		return solde;
	}

	public Double getTauxInteret() {
		return tauxInteret;
	}

	public Set<User> getUsers() {
		return users;
	}

	public final void setCompteId(String compteId) {
		this.compteId = compteId;
	}

	public final void setCompteType(CompteType compteType) {
		this.compteType = compteType;
	}

	public void setNumCarte(String numCarte) {
		this.numCarte = numCarte;
	}

	public final void setSolde(Double solde) {
		this.solde = solde;
	}

	public void setTauxInteret(Double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public final String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Compte [compteType=").append(compteType)
				.append(", solde=").append(solde).append(", compteId=")
				.append(compteId).append("]");
		return builder.toString();
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

}