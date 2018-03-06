package com.formation.tutorial.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.formation.tutorial.domain.Event;
import com.formation.tutorial.domain.Person;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

				Map<String, String> settings = new HashMap<>();
				settings.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
				settings.put("hibernate.connection.url", "jdbc:mysql://10.33.131.118/formationdb");
				settings.put("hibernate.connection.username", "formation");
				settings.put("hibernate.connection.password", "Formation02!");
				settings.put("hibernate.show_sql", "false");
				//settings.put("hibernate.hbm2ddl.auto", "create-drop");
				settings.put("hibernate.hbm2ddl.auto", "update");

				registry = registryBuilder.applySettings(settings).build();

				MetadataSources sources = new MetadataSources(registry)
						.addAnnotatedClass(Event.class)
						.addAnnotatedClass(Person.class);

				Metadata metadata = sources.getMetadataBuilder().build();

				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				System.out.println("SessionFactory creation failed");
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
