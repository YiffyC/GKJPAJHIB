package com.formation.tutotrial;

import org.hibernate.Session;

import com.formation.tutorial.domain.Student;
import com.formation.tutorial.util.HibernateUtil;

public class StudentManager {
	
	public static void main(String[] args)
	{
		StudentManager sm = new StudentManager();
		sm.createAndStoreStudent("Nom", "Prenom");
		HibernateUtil.getSessionFactory().close();
	}

	private void createAndStoreStudent(String name, String forname)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Student s = new Student();
		s.setName(name);
		s.setFirstname(forname);
		session.save(s);

		System.out.println(s);

		session.getTransaction().commit();
	}

}
