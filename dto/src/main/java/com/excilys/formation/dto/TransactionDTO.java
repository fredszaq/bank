package com.excilys.formation.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

import com.excilys.formation.bank.bean.Etat;
import com.excilys.formation.bank.bean.TransactionCategorie;

/**
 * Transaction Data Transfer Object.
 * 
 * @author excilys
 * 
 */
@XmlRootElement
public class TransactionDTO {

	private DateTime dateInit;

	private DateTime dateValid;

	private Etat etat;

	private String libelle;

	private TransactionCategorie transactionCategorie;

	public final DateTime getDateInit() {
		return dateInit;
	}

	public final void setDateInit(DateTime dateInit) {
		this.dateInit = dateInit;
	}

	public final DateTime getDateValid() {
		return dateValid;
	}

	public final void setDateValid(DateTime dateValid) {
		this.dateValid = dateValid;
	}

	public final Etat getEtat() {
		return etat;
	}

	public final void setEtat(Etat etat) {
		this.etat = etat;
	}

	public final String getLibelle() {
		return libelle;
	}

	public final void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public final TransactionCategorie getTransactionCategorie() {
		return transactionCategorie;
	}

	public final void setTransactionCategorie(
			TransactionCategorie transactionCategorie) {
		this.transactionCategorie = transactionCategorie;
	}

	/**
	 * Builder TransactionDTO.
	 * 
	 * @author excilys
	 * 
	 */
	public static class TransactionDTOBuilder {
		private final TransactionDTO transactionDTO = new TransactionDTO();

		/**
		 * Add dateInit to transactionDTO.
		 * 
		 * @param dateInit
		 *            date Init
		 * @return TransactionDTOBuilder
		 */
		public final TransactionDTOBuilder withDateInit(DateTime dateInit) {
			transactionDTO.setDateInit(dateInit);
			return this;
		}

		/**
		 * Add dateValid to transactionDTO.
		 * 
		 * @param dateValid
		 *            date Valid
		 * @return TransactionDTOBuilder
		 */
		public final TransactionDTOBuilder withDateValid(DateTime dateValid) {
			transactionDTO.setDateValid(dateValid);
			return this;
		}

		/**
		 * Add etat to transactionDTO.
		 * 
		 * @param etat
		 *            etat
		 * @return TransactionDTOBuilder
		 */
		public final TransactionDTOBuilder withEtat(Etat etat) {
			transactionDTO.setEtat(etat);
			return this;
		}

		/**
		 * Add libelle to transactionDTO.
		 * 
		 * @param libelle
		 *            libelle
		 * @return TransactionDTOBuilder
		 */
		public final TransactionDTOBuilder withLibelle(String libelle) {
			transactionDTO.setLibelle(libelle);
			return this;
		}

		/**
		 * Add transactionCategorie to transactionDTO.
		 * 
		 * @param transactionCategorie
		 *            transaction categorie
		 * @return TransactionDTOBuilder
		 */
		public final TransactionDTOBuilder withTransactionCategorie(
				TransactionCategorie transactionCategorie) {
			transactionDTO.setTransactionCategorie(transactionCategorie);
			return this;
		}

		/**
		 * Build the TransactionDTO.
		 * 
		 * @return Transaction DTO
		 */
		public final TransactionDTO build() {
			return transactionDTO;
		}
	}

}
