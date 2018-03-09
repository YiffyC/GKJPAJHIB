package com.formation.tutorial.hibernate.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
public class Company {
	private int companyId;
	private String companyName;
	private List<Employee> employees;

	@Id
	@Column(name = "COMPANY_ID")
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Column(name = "COMPANY_NAME")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	@Column(name = "EMPLOYEE_LIST")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Employee> getEmployees()
	{
		return employees;
	}

	public void setEmployees(List<Employee> employees)
	{
		this.employees = employees;
	}
	
	public void addEmployeeToCompagny(Employee e)
	{
		this.employees.add(e);
	}
	

	
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", agencies=" +  "]";
	}


	
}
