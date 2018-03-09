package com.formation.tutorial.hibernate.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class BeanEmployee
{
	private int id;
	private String name;
	private String email;
	
	
	void BeanEmployee(int i, String n, String e)
	{
		this.id = i;
		this.name = n;
		this.email = e;
	}
	
	//getset
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setInfoFromDb(int id, EntityManager entityManager)
	{
		this.id = id;
		this.email = null;
		this.name = null;
		
		
		this.email = (String) entityManager.createQuery("SELECT email FROM Employee WHERE employee_id = "+id).getSingleResult();
		this.name = (String) entityManager.createQuery("SELECT name FROM Employee WHERE employee_id = "+id).getSingleResult();
		
		
	}
	
	public void deleteFromDb(int id, EntityManager entityManager)
	{
		entityManager.createQuery("DELETE FROM Employee WHERE employee_id = "+id).getSingleResult();
	}
	
	
	public void updateInDb(int id, String name, String mail, EntityManager entityManager)
	{
		entityManager.createQuery("UPDATE Employee employee_id = '" +id+ ", name='" +name+ "', email='" +mail +"' WHERE employee_id = "+id).getSingleResult();
	}
	public void createInDb(Employee e, EntityManager entityManager)
	{
		entityManager.persist(e);
	}
	
	
	
}
