package com.formation.tutotrial;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.formation.tutorial.domain.Event;
import com.formation.tutorial.domain.Person;
import com.formation.tutorial.util.HibernateUtil;



public class EventManager
{
	public static void main (String args[])
	{
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.getTransaction();
			transaction.begin();
			EventManager em = new EventManager();
			em.createAndStoreEvent("Journée de repos", new Date(), session
					);
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
	
	
	private void createAndStoreEvent(String title, Date d, Session session)
	{

		Event e = new Event();
		e.setDate(d);
		e.setTitle(title);
		session.save(e);

		System.out.println(e);
	}
}
