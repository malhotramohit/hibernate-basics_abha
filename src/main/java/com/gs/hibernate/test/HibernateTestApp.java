package com.gs.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gs.hibernate.models.Flights;

public class HibernateTestApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Flights flights1 = new Flights(1, "PUJP90776");
		session.beginTransaction();
		session.save(flights1);
		session.getTransaction().commit();
		session.close();
	}
}
