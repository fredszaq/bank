package com.excilys.formation.bank.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.excilys.formation.bank.bean.SomeEntity;

/**
 * A dao class to work with hibernate 4.
 * 
 * @author excilys
 * 
 */
@Repository("someDAOHibernate")
public class SomeDAOHibernate implements SomeDAOInterface {

	/**
	 * The Hibernate SessionFactory.
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * delete an entity.
	 * 
	 * @param entity
	 *            the entity to delete
	 */
	@Override
	@Transactional
	public final void deleteEntity(SomeEntity entity) {
		this.sessionFactory.getCurrentSession().delete(entity);
	}

	/**
	 * find all entities.
	 * 
	 * @return the list of all entities
	 */
	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public final List<SomeEntity> findAllEntities() {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from SomeEntity").list();
	}

	/**
	 * get an entity by string.
	 * 
	 * @param string
	 *            the string
	 * @return the entity
	 */
	@Override
	@Transactional
	public final SomeEntity getEntityByString(String string) {
		return (SomeEntity) this.sessionFactory.getCurrentSession().get(
				SomeEntity.class, string);

	}

	/**
	 * save an entity.
	 * 
	 * @param entity
	 *            the entity to save
	 */
	@Override
	@Transactional
	public final void saveEntity(SomeEntity entity) {
		this.sessionFactory.getCurrentSession().save(entity);
	}

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
	 * update an existing entity.
	 * 
	 * @param entity
	 *            the entity to update
	 */
	@Override
	@Transactional
	public final void updateEntity(SomeEntity entity) {
		this.sessionFactory.getCurrentSession().update(entity);
	}

}
