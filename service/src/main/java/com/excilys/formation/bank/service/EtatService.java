package com.excilys.formation.bank.service;

import com.excilys.formation.bank.bean.Etat;
import com.excilys.formation.bank.bean.Etat.EtatType;

public interface EtatService {

	Etat getEtatByType(EtatType etatType);

}
