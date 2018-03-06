package com.formation.tutotrial;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.formation.tutorial.domain.Event;
import com.formation.tutorial.domain.Person;
import com.formation.tutorial.util.HibernateUtil;

public class PersonManager {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.getTransaction();
			transaction.begin();
			PersonManager mgr = new PersonManager();
			//mgr.createAndStorePerson((long)6666, "Berenger", "Thevenet", 23, session);
			
			Person p = session.find(Person.class, 6666);
			System.out.println(p);
			transaction.commit();
			System.out.println("Records saved successfully");

		} catch (

		Exception e) {
			if (transaction != null) {
				System.out.println("Transaction is being rolled back.");
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		HibernateUtil.shutdown();
	}

	private void createAndStorePerson(Long i, String firstname, String lastname, int age, Session session) {

		Event e = new Event();	
		Person person = new Person();
		
		e.setId(i);
		e.setDate(new Date());
		e.setTitle("Incoming Atos Berenger");
		session.saveOrUpdate(e);
		
		person.setId(i);
		person.setFirstname(firstname);
		person.setLastname(lastname);
		person.setAge(age);
		person.setEvent(e);
		session.saveOrUpdate(person);

		//Aller lire en base
		//session.find(Person.class, id);
		
		
		System.out.println(person);
		System.out.println(e);
		
	}

}