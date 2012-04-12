package com.excilys.formation.dto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.dto.CompteDTO;
import com.excilys.formation.dto.CompteDTO.CompteDTOBuilder;

@Component("Compte2CompteDTOConverter")
public class Compte2CompteDTOConverter implements Converter<Compte, CompteDTO> {

	@Override
	public CompteDTO convert(Compte compte) {
		return new CompteDTO.CompteDTOBuilder()
				.withCompteType(compte.getCompteType())
				.withNumCarte(compte.getNumCarte())
				.withSolde(compte.getSolde())
				.withTauxInteret(compte.getTauxInteret()).build();
	}
}
