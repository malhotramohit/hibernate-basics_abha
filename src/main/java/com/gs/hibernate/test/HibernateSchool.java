package com.gs.hibernate.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gs.hibernate.models.Standard;
import com.gs.hibernate.models.Teacher;

public class HibernateSchool {
	public static void main(String[] args) {

		Teacher teacher1 = new Teacher("Mohit", 25); // 08/11/93 // 08/11/1993
		Teacher teacher2 = new Teacher("Mandeep", 25);

		Standard standard1 = new Standard("Class 8-A", 12);
		Standard standard2 = new Standard("Class 8-B", 13);

		List<Teacher> teachers = new ArrayList<Teacher>(2);
		teachers.add(teacher1);
		teachers.add(teacher2);

		List<Standard> standards = new ArrayList<Standard>(2);
		standards.add(standard1);
		standards.add(standard2);

		teacher1.setStandards(standards);
		teacher2.setStandards(standards);

		standard1.setTeachers(teachers);
		standard2.setTeachers(teachers);

		// save teacher1 into DB
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		for (Teacher teacher : teachers) {
			session.save(teacher);
		}
		for (Standard std : standards) {
			session.save(std);
		}

		session.getTransaction().commit();

	}

}
