package com.formation.tutorial.hibernate.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Sylvain LALLIER
 *
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee
{
	@Id
	@Column(name = "employee_id")
	private Integer employeeId;

	private String name;
	private String email;
	
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name = "employee_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	
	@Column(name = "employee_email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	



	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", email=" + email +  "]";
	}

}
