package com.excilys.formation.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SomeDAOHibernate implements SomeDAOInterface {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public SomeEntity getEntityByString(String string) {
		return (SomeEntity) sessionFactory.getCurrentSession().get(
				SomeEntity.class, string);

	}

	@Transactional
	public List<SomeEntity> findAllEntities() {
		return sessionFactory.getCurrentSession()
				.createQuery("from SomeEntity").list();
	}

	@Transactional
	public void saveEntity(SomeEntity entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Transactional
	public void updateEntity(SomeEntity entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Transactional
	public void deleteEntity(SomeEntity entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

}
