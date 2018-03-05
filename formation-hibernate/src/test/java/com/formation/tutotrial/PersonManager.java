package com.formation.tutotrial;

import org.hibernate.Session;

import com.formation.tutorial.domain.Person;
import com.formation.tutorial.util.HibernateUtil;

public class PersonManager {

	public static void main(String[] args) {
		PersonManager mgr = new PersonManager();
		mgr.createAndStorePerson("John", "Smith", 30);
		HibernateUtil.getSessionFactory().close();
	}

	private void createAndStorePerson(String firstname, String lastname, int age) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Person person = new Person();
		person.setFirstname(firstname);
		person.setLastname(lastname);
		person.setAge(age);

		session.save(person);

		System.out.println(person);

		session.getTransaction().commit();
	}

}