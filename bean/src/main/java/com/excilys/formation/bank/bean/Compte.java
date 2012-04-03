package com.excilys.formation.bank.bean;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

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
	 * 
	 */
	private static final long serialVersionUID = -5415634325439473807L;

	/**
	 * CompteType enum.
	 * 
	 * @author excilys
	 * 
	 */

	@Column(name = "compte_type")
	@Type(type = "com.excilys.formation.bank.bean.StringEnumPersistenceType", parameters = {
			@Parameter(name = "enumClass", value = "com.excilys.formation.bank.bean.CompteType"),

			@Parameter(name = "identifierMethod", value = "getCompteType"),

			@Parameter(name = "valueOfMethod", value = "valueByString") })
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

	public final String getNumCarte() {
		return numCarte;
	}

	public final Double getSolde() {
		return solde;
	}

	public final Double getTauxInteret() {
		return tauxInteret;
	}

	public final Set<User> getUsers() {
		return users;
	}

	public final void setCompteId(String compteId) {
		this.compteId = compteId;
	}

	public final void setCompteType(CompteType compteType) {
		this.compteType = compteType;
	}

	public final void setNumCarte(String numCarte) {
		this.numCarte = numCarte;
	}

	public final void setSolde(Double solde) {
		this.solde = solde;
	}

	public final void setTauxInteret(Double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	public final void setUsers(Set<User> users) {
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

	public final Set<Operation> getOperations() {
		return operations;
	}

	public final void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

	public boolean hasCarte() {
		return getNumCarte() == null ? false : true;
	}

}