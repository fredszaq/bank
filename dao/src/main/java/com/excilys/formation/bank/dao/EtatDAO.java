package com.excilys.formation.bank.dao;

import com.excilys.formation.bank.bean.Etat;
import com.excilys.formation.bank.bean.Etat.EtatType;

public interface EtatDAO {
	Etat getEtatByType(EtatType etatType);
}
