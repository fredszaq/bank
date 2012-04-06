package com.excilys.formation.webservicers.dto.bean;

import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

import com.excilys.formation.bank.bean.Etat;
import com.excilys.formation.bank.bean.TransactionCategorie;

@XmlRootElement
public class TransactionDTO {

	private DateTime dateInit;

	private DateTime dateValid;

	private Etat etat;

	private String libelle;

	private TransactionCategorie transactionCategorie;

	public DateTime getDateInit() {
		return dateInit;
	}

	public void setDateInit(DateTime dateInit) {
		this.dateInit = dateInit;
	}

	public DateTime getDateValid() {
		return dateValid;
	}

	public void setDateValid(DateTime dateValid) {
		this.dateValid = dateValid;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public TransactionCategorie getTransactionCategorie() {
		return transactionCategorie;
	}

	public void setTransactionCategorie(
			TransactionCategorie transactionCategorie) {
		this.transactionCategorie = transactionCategorie;
	}

	public static class TransactionDTOBuilder {
		private final TransactionDTO transactionDTO = new TransactionDTO();

		public TransactionDTOBuilder withDateInit(DateTime dateInit) {
			transactionDTO.setDateInit(dateInit);
			return this;
		}

		public TransactionDTOBuilder withDateValid(DateTime dateValid) {
			transactionDTO.setDateValid(dateValid);
			return this;
		}

		public TransactionDTOBuilder withEtat(Etat etat) {
			transactionDTO.setEtat(etat);
			return this;
		}

		public TransactionDTOBuilder withLibelle(String libelle) {
			transactionDTO.setLibelle(libelle);
			return this;
		}

		public TransactionDTOBuilder withTransactionCategorie(
				TransactionCategorie transactionCategorie) {
			transactionDTO.setTransactionCategorie(transactionCategorie);
			return this;
		}

		public TransactionDTO build() {
			return transactionDTO;
		}
	}

}
