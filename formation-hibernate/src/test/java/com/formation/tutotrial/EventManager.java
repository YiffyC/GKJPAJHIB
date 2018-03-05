package com.formation.tutotrial;

import java.util.Date;

import org.hibernate.Session;

import com.formation.tutorial.domain.Event;
import com.formation.tutorial.util.HibernateUtil;

/**
 * 
 * @author slallier
 *
 */

public class EventManager
{

	public static void main(String[] args)
	{
		EventManager mgr = new EventManager();

		mgr.createAndStoreEvent("My Event", new Date());
		HibernateUtil.getSessionFactory().close();
	}

	private void createAndStoreEvent(String title, Date theDate)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Event theEvent = new Event();
		theEvent.setTitle(title);
		theEvent.setDate(theDate);
		session.save(theEvent);

		System.out.println(theEvent);

		session.getTransaction().commit();
	}

}