package com.excilys.formation.webservicers.dto.bean;

import javax.xml.bind.annotation.XmlRootElement;

import com.excilys.formation.bank.bean.CompteType;

@XmlRootElement
public class CompteDTO {
	private CompteType compteType;

	private long solde;

	private Double tauxInteret;

	private String numCarte;

	public CompteType getCompteType() {
		return compteType;
	}

	public void setCompteType(CompteType compteType) {
		this.compteType = compteType;
	}

	public long getSolde() {
		return solde;
	}

	public void setSolde(long solde) {
		this.solde = solde;
	}

	public Double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(Double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	public String getNumCarte() {
		return numCarte;
	}

	public void setNumCarte(String numCarte) {
		this.numCarte = numCarte;
	}

	public static class CompteDTOBuilder {
		private final CompteDTO compteDTO = new CompteDTO();

		public CompteDTOBuilder withCompteType(CompteType compteType) {
			compteDTO.setCompteType(compteType);
			return this;
		}

		public CompteDTOBuilder withSolde(long solde) {
			compteDTO.setSolde(solde);
			return this;
		}

		public CompteDTOBuilder withTauxInteret(Double tauxInteret) {
			compteDTO.setTauxInteret(tauxInteret);
			return this;
		}

		public CompteDTOBuilder withNumCarte(String numCarte) {
			compteDTO.setNumCarte(numCarte);
			return this;
		}

		public CompteDTO build() {
			return compteDTO;
		}
	}

}
