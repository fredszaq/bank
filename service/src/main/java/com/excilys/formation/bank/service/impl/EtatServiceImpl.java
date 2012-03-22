package com.excilys.formation.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.excilys.formation.bank.bean.Etat;
import com.excilys.formation.bank.bean.Etat.EtatType;
import com.excilys.formation.bank.dao.EtatDAO;
import com.excilys.formation.bank.service.EtatService;

@Service("etatService")
@Transactional(readOnly = true)
public class EtatServiceImpl implements EtatService {

	@Autowired
	private EtatDAO etatDAO;

	@Override
	public Etat getEtatByType(EtatType etatType) {
		return etatDAO.getEtatByType(etatType);
	}

}
