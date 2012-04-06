package com.excilys.formation.webservicers.dto.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.excilys.formation.bank.bean.Etat;
import com.excilys.formation.bank.bean.TransactionCategorie;

@XmlRootElement(name = "TransactionDTO")
public class TransactionDTO {

	private Date dateInit;

	private Date dateValid;

	private Etat etat;

	private String libelle;

	private TransactionCategorie transactionCategorie;

	public Date getDateInit() {
		return dateInit;
	}

	public void setDateInit(Date dateInit) {
		this.dateInit = dateInit;
	}

	public Date getDateValid() {
		return dateValid;
	}

	public void setDateValid(Date dateValid) {
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

		public TransactionDTOBuilder withDateInit(Date dateInit) {
			transactionDTO.setDateInit(dateInit);
			return this;
		}

		public TransactionDTOBuilder withDateValid(Date dateValid) {
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
