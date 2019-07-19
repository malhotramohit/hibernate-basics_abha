package com.gs.hibernate.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.gs.hibernate.models.Passenger;
import com.gs.hibernate.models.Ticket;

public class HibernateTestApp1 {
	public static void main(String[] args) {

		// exForCasFetchGetLoad();
		Passenger passenger1 = new Passenger("Rajnish", 30);
		Passenger passenger3 = new Passenger("mohit", 45);

		Ticket ticket = new Ticket("PUDL1234", 5435.455);
		passenger1.setTickets(Arrays.asList(new Ticket[] { ticket }));
		ticket.setPassesnger(passenger1);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(passenger1);
		session.save(passenger3);
		session.save(ticket);
		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		Query query = session.createNamedQuery("Passenger.getPassengerByAge");
		query.setParameter("age", 30);
		Passenger passenger = (Passenger) query.getResultList().get(0);
		System.out.println(passenger);
		System.out.println("pass by name is ---");
		query = session.createNamedQuery("Passenger.getPassengerByName");
		query.setParameter("passengerName", "Rajnish");
		Passenger passenger2 = (Passenger) query.getResultList().get(0);
		System.out.println(passenger2);

		System.out.println("by ticket price");
		Query query2 = session.createNamedQuery("Ticket.getTicketWithPassByTicketPrice");
		query2.setParameter("price", 5435.455);
		Passenger passenger33 = (Passenger) query2.getResultList().get(0);
		System.out.println(passenger33);

		System.out.println("by ticket proce pass name and age");
		query2 = session.createNamedQuery("Ticket.getPassNameAnaAgeByTicketPrice");
		query2.setParameter("price", 5435.455);
		List<Object[]> objects = query2.getResultList();
		Passenger passenger334 = new Passenger();
		for (Object[] objectArray : objects) {
			passenger334.setPassengerName(String.valueOf(objectArray[0]));
			passenger334.setAge(Integer.valueOf(String.valueOf(objectArray[1])));

		}
		// Passenger passenger334 = (Passenger) query2.getResultList().get(0);
		System.out.println(passenger334);

		// query =
		// session.createNamedQuery("Passenger.getPassenegerByTicketPriceNative");
		query = session.createNamedQuery("Passenger.getPassenegerByTicketPriceNative");
		query.setParameter("price", new Double(5435.455));
		List<Object[]> objects1 = query.getResultList();
		System.out.println(objects1);

		System.out.println("get all passengers natively");
		query = session.createNamedQuery("Passenger.getPassenegersNative");
		List<Object[]> objects12 = query.getResultList();
		// objects12: rows
		// rows(i) : object[]
		// object[0] : 1st col
		// object[1] :2nd col
		System.out.println(objects12);
		
		System.out.println("get all passengers natively without pojo");
		query = session.createNativeQuery("select pt.*  from passenger_table pt");
		List<Object[]> objects123 = query.getResultList();
		// objects12: rows
		// rows(i) : object[]
		// object[0] : 1st col
		// object[1] :2nd col
		System.out.println(objects123);
		

	}

	private static void exForCasFetchGetLoad() {
		// lastClassExample();
		Passenger passenger1 = new Passenger("Rajnish", 30);
		Ticket ticket = new Ticket("PUDL1234", 5435.455);
		passenger1.setTickets(Arrays.asList(new Ticket[] { ticket }));
		ticket.setPassesnger(passenger1);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(passenger1);
		// session.save(ticket);
		session.getTransaction().commit();
		session.close();

		// case 1: LAzy Loading : fetch type : lazy, eager
		// session = sessionFactory.openSession();
		// Passenger passenger2 = session.get(Passenger.class, new Long(1));
		// session.close();
		// System.out.println(passenger2.getTickets().get(0).getTicketName());

		// get vs load
		// get : given null if the no obj is present
		// get : looks directly in the DB
		// get : slow
		// get : fetch the whole object

		// load : give objectnot found if not present
		// load : give proxy (dummy / copy of the object)which will have only id
		// load : will not fire any query untill and unless some attribute than id is
		// called
		// load : better performanve
		// load : used when only id is required not the complete object
		// load : same hashcode

		// session = sessionFactory.openSession();
		// Passenger passenger2 = session.load(Passenger.class, new Long(10));
		// System.out.println("passenger id is " + passenger2.getSeq() + "pass age is "
		// + passenger2.getAge());
		// session.close();

		// session = sessionFactory.openSession();
		// Passenger passenger2 = session.load(Passenger.class, new Long(1));
		// Passenger passenger22 = session.load(Passenger.class, new Long(1));
		// System.out.println(passenger2.hashCode());
		// System.out.println(passenger22.hashCode());
		//
		// System.out.println("passenger id is " + passenger2.getSeq() + "pass age is "
		// + passenger2.getAge());
		// session.close();

		session = sessionFactory.openSession();
		Passenger passenger2 = session.load(Passenger.class, new Long(1));
		System.out.println(passenger2.hashCode());
		session.close();
		session = sessionFactory.openSession();
		Passenger passenger22 = session.load(Passenger.class, new Long(1));
		System.out.println(passenger22.hashCode());
		System.out.println("passenger id is " + passenger22.getSeq());
		System.out.println("pass age is " + passenger22.getAge());
		session.close();
	}

	private static void lastClassExample() {

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

		session.beginTransaction();
		Passenger passenger12 = new Passenger("Abah", 25);

		Ticket ticket1 = new Ticket("GOPU123", 445.4553);
		Ticket ticket2 = new Ticket("PUGO12", 24234.4553);

		ticket1.setPassesnger(passenger12);
		ticket2.setPassesnger(passenger12);

		List<Ticket> tickets = new ArrayList<Ticket>();
		tickets.add(ticket1);
		tickets.add(ticket2);

		passenger12.setTickets(tickets);

		// ticket.setPassenger(passenger12);

		for (int i = 0; i < tickets.size(); i++) {
			session.save(tickets.get(i));
		}

		session.save(passenger12);

		session.getTransaction().commit();
		session.close();

	}

}
