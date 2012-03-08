package com.excilys.formation.dao;

import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"beans-context.xml");
		SomeDAOInterface dao = ctx.getBean(SomeDAOInterface.class);

		SomeEntity entity = new SomeEntity();
		entity.setSomeDate(new GregorianCalendar(2010, 1, 2).getTime());
		entity.setSomeInteger(3);
		entity.setSomeString("mwahaha");

		SomeEntity entity2 = new SomeEntity();
		entity2.setSomeDate(new GregorianCalendar(2012, 1, 2).getTime());
		entity2.setSomeInteger(2);
		entity2.setSomeString("hohoho");

		dao.saveEntity(entity);
		dao.saveEntity(entity2);

		for (SomeEntity someEntity : dao.findAllEntities()) {
			System.out.println(someEntity);
		}

		entity.setSomeInteger(5);
		entity2.setSomeDate(new GregorianCalendar(2011, 1, 2).getTime());

		dao.updateEntity(entity);
		dao.updateEntity(entity2);

		for (SomeEntity someEntity : dao.findAllEntities()) {
			System.out.println(someEntity);
		}

		dao.deleteEntity(entity);
		dao.deleteEntity(entity2);

		for (SomeEntity someEntity : dao.findAllEntities()) {
			System.out.println(someEntity);
		}
	}

}
