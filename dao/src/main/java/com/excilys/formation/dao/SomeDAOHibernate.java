package com.excilys.formation.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * A dao class to work with hibernate 4.
 * 
 * @author excilys
 * 
 */
@Repository
public class SomeDAOHibernate implements SomeDAOInterface {

	/**
	 * The Hibernate SessionFactory.
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * set the SessionFactory.
	 * 
	 * @param factory
	 *            the factory to be used
	 */
	public final void setSessionFactory(SessionFactory factory) {
		this.sessionFactory = factory;
	}

	/**
	 * get an entity by string.
	 * 
	 * @param string
	 *            the string
	 * @return the entity
	 */
	@Transactional
	public final SomeEntity getEntityByString(String string) {
		return (SomeEntity) sessionFactory.getCurrentSession().get(
				SomeEntity.class, string);

	}

	/**
	 * find all entities.
	 * 
	 * @return the list of all entities
	 */
	@Transactional
	public final List<SomeEntity> findAllEntities() {
		return sessionFactory.getCurrentSession()
				.createQuery("from SomeEntity").list();
	}

	/**
	 * save an entity.
	 * 
	 * @param entity
	 *            the entity to save
	 */
	@Transactional
	public final void saveEntity(SomeEntity entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	/**
	 * update an existing entity.
	 * 
	 * @param entity
	 *            the entity to update
	 */
	@Transactional
	public final void updateEntity(SomeEntity entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	/**
	 * delete an entity.
	 * 
	 * @param entity
	 *            the entity to delete
	 */
	@Transactional
	public final void deleteEntity(SomeEntity entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

}
