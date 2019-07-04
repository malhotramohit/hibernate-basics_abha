package com.gs.hibernate.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gs.hibernate.models.Passenger;
import com.gs.hibernate.models.Ticket;

public class HibernateTestApp1 {
	public static void main(String[] args) {

		Ticket ticket6 = new Ticket("Noram", 24545345.5646, new Date());
		Ticket ticket4 = new Ticket("Norma", 454345435535.5646, new Date());
		Ticket ticket5 = new Ticket("Norma", 543.5646, new Date());

		// ? hib
		// create a table ticket in db
		// to save this object as a row in table ticket

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		ticket4.setDate2(new Date());
		ticket4.setDate3(new Date());
		ticket4.setDate4(new Date());
		session.save(ticket4);
		session.getTransaction().commit();

		Transaction transaction = session.beginTransaction();

		session.save(ticket5);

		// if (true) {
		// throw new NullPointerException();
		// }

		session.save(ticket6);

		// session.save(ticket1);

		transaction.commit();
		session.close();

		session = sessionFactory.openSession();

		Ticket ticketFromDB = session.get(Ticket.class, new Long(4));
		System.out.println(ticketFromDB);

		Passenger passenger1 = new Passenger("Mohit", 23);
		Passenger passenger2 = new Passenger("Rohit", 24);

		session.beginTransaction();
		session.save(passenger1);
		session.save(passenger2);
		session.getTransaction().commit();

	}

}
