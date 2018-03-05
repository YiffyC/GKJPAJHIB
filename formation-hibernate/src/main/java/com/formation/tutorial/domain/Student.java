package com.formation.tutorial.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student implements Serializable
{
	private static final long serialVersionUID = -3065897724116928190L;

	@Id
	@GeneratedValue
	@Column(name="STUDENT_ID")
	private int id;
	
	@Column (nullable = false) 
	private Date dateInsc;
	private String name;
	private String firstname;
	
	//cstruct
	
	public Student(String n, String f)
	{
		dateInsc = new Date();
		name = n;
		name = f;
	}
	
	public Student()
	{
		dateInsc = new Date();
	}
	
	//getset
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Date getDateInsc() {
		return dateInsc;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	
	@Override
	public String toString()
	{
		return "Event [name=" + name + ", firstname=" + firstname + ", date=" + dateInsc + "]";
	}

	
	
}
