package com.excilys.formation.bank.dao;

import java.util.List;

import com.excilys.formation.bank.bean.SomeEntity;

/**
 * TODO delete this.
 * 
 * @author excilys
 * 
 */
public interface SomeDAOInterface {

	/**
	 * TODO delete this.
	 * 
	 * @param entity
	 *            aa
	 */
	void deleteEntity(SomeEntity entity);

	/**
	 * TODO delete this.
	 * 
	 * @return aa
	 */
	List<SomeEntity> findAllEntities();

	/**
	 * TODO delete this.
	 * 
	 * @param string
	 *            aa
	 * @return aa
	 */
	SomeEntity getEntityByString(String string);

	/**
	 * TODO delete this.
	 * 
	 * @param entity
	 *            aa
	 */
	void saveEntity(SomeEntity entity);

	/**
	 * TODO delete this.
	 * 
	 * @param entity
	 *            aa
	 */
	void updateEntity(SomeEntity entity);

}