package com.formation.tutorial.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author slallier
 */
@Entity
@Table(name = "PERSON")
public class Person implements Serializable
{
	private static final long serialVersionUID = -3129713844982050964L;
	@Id
	//@GeneratedValue
	@Column(name = "PERSON_ID")
	private int id;
	private int age;
	private String firstname;
	private String lastname;
	private int note;

	@OneToOne
	private Event event;
	

	// @ManyToMany
	// @JoinTable(name = "PERSON_EVENT", joinColumns = @JoinColumn(name =
	// "PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "EVENT_ID"))
	// private Set<Event> events;

	public Person() {}

	public Person(String firstname, String lastname, int age) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}
	
	
	public Event getEvent() {
		return event;
	}

	@OneToOne
	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", age=" + age + ", firstname=" + firstname + ", lastname=" + lastname + ", note : " + note+ "]";
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
}
