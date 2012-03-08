package com.excilys.formation.dao;

import java.util.List;

public interface SomeDAOInterface {

	public abstract SomeEntity getEntityByString(String string);

	public abstract List<SomeEntity> findAllEntities();

	public abstract void saveEntity(SomeEntity entity);

	public abstract void updateEntity(SomeEntity entity);

	public abstract void deleteEntity(SomeEntity entity);

}