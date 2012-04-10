package com.excilys.formation.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.excilys.formation.bank.bean.CompteType;

/**
 * Compte Data Transfer Object.
 * 
 * @author excilys
 * 
 */
@XmlRootElement
public class CompteDTO {
	private CompteType compteType;

	private long solde;

	private Double tauxInteret;

	private String numCarte;

	public final CompteType getCompteType() {
		return compteType;
	}

	public final void setCompteType(CompteType compteType) {
		this.compteType = compteType;
	}

	public final long getSolde() {
		return solde;
	}

	public final void setSolde(long solde) {
		this.solde = solde;
	}

	public final Double getTauxInteret() {
		return tauxInteret;
	}

	public final void setTauxInteret(Double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	public final String getNumCarte() {
		return numCarte;
	}

	public final void setNumCarte(String numCarte) {
		this.numCarte = numCarte;
	}

	/**
	 * Builder Compte DTO.
	 * 
	 * @author excilys
	 * 
	 */
	public static class CompteDTOBuilder {
		private final CompteDTO compteDTO = new CompteDTO();

		/**
		 * Add compteType to compteDTO.
		 * 
		 * @param compteType
		 *            CompteType
		 * @return CompteDTOBuilder
		 */
		public final CompteDTOBuilder withCompteType(CompteType compteType) {
			compteDTO.setCompteType(compteType);
			return this;
		}

		/**
		 * Add solde to compteDTO.
		 * 
		 * @param solde
		 *            Solde
		 * @return CompteDTOBuilder
		 */
		public final CompteDTOBuilder withSolde(long solde) {
			compteDTO.setSolde(solde);
			return this;
		}

		/**
		 * Add tauxInteret to compteDTO.
		 * 
		 * @param tauxInteret
		 *            tauxInteret
		 * @return CompteDTOBuilder
		 */
		public final CompteDTOBuilder withTauxInteret(Double tauxInteret) {
			compteDTO.setTauxInteret(tauxInteret);
			return this;
		}

		/**
		 * Add numCarte to compteDTO.
		 * 
		 * @param numCarte
		 *            numero de carte
		 * @return CompteDTOBuilder
		 */
		public final CompteDTOBuilder withNumCarte(String numCarte) {
			compteDTO.setNumCarte(numCarte);
			return this;
		}

		/**
		 * Build the CompteDTO.
		 * 
		 * @return CompteDTO
		 */
		public final CompteDTO build() {
			return compteDTO;
		}
	}

}
