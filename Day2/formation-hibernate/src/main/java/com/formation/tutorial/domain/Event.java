package com.formation.tutorial.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author slallier
 *
 */
@Entity
@Table(name="EVENT")
public class Event implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4653663252654727887L;

	@Id
	//@GeneratedValue
	@Column(name="EVENT_ID")
	private Long id;	

	private String title;
	private Date date;
	

	public Event() {
	}

	public Long getId() {
		return id;
	}

	//@SuppressWarnings("unused")
	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString()
	{
		return "Event [id=" + id + ", title=" + title + ", date=" + date + "]";
	}

}
