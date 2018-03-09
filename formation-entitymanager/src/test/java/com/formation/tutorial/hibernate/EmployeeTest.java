package com.formation.tutorial.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.formation.tutorial.hibernate.domain.BeanEmployee;
import com.formation.tutorial.hibernate.domain.Company;
import com.formation.tutorial.hibernate.domain.Employee;

/**
 * @author Sylvain LALLIER
 *
 */
public class EmployeeTest {
	public static void main(String[] args)
	{
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emplyee");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Starting Transaction");
		entityManager.getTransaction().begin();

		
		//create employee
		
		/*
		Employee employee = new Employee();
		employee.setEmployeeId(1234);
		employee.setName("Naouel");
		employee.setEmail("na.ouel@mail.fr");
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		System.out.println("Result Employee ID = " + employee.getEmployeeId());
		// get an object using primary key.
		Employee emp = entityManager.find(Employee.class, employee.getEmployeeId());
		System.out.println("Got Employee " + emp.getName() + " " + emp.getEmployeeId());
		*/
		
		
		
		//create compagny
		/*
		Company cmp = new Company();
		cmp.setCompanyId(1108);
		cmp.setCompanyName("Berenger Compagny");
		entityManager.persist(cmp);
		entityManager.getTransaction().commit();
		System.out.println("Result compagny ID = " + cmp.getCompanyId() + " Result compagny name = " + cmp.getCompanyName());
		*/

		  
		//Ajout emp to cmp
		//linkEmployeeToCompagny(1234, 1108, entityManager);
	
		
		
		/*
		 * Display
		 */
		displayEveything(entityManager);
		
		
		
		// remove and entity
		/*
		entityManager.getTransaction().begin();
		System.out.println("Deleting Employee with ID = " + emp.getEmployeeId());
		entityManager.remove(emp);
		entityManager.getTransaction().commit();
		*/
		
		
		/*
		 * springbeans
		 */
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "appConfig.xml" });
		BeanEmployee beanEmp = (BeanEmployee) appContext.getBean("beanEmp");
		beanEmp.setInfoFromDb(1108, entityManager);
		System.out.println("[id : " + beanEmp.getId() + " Nom : " + beanEmp.getName() + " Mail : " + beanEmp.getEmail() + "]");
		
		Employee alpha = new Employee();
		alpha.setEmail("alpha@@");
		alpha.setName("alpha");
		alpha.setEmployeeId(1);
		
		//envoi de alpha en base
		beanEmp.createInDb(alpha, entityManager);
		//delete alpha
		beanEmp.deleteFromDb(1, entityManager);
		
		
		
		// close the entity manager
		entityManager.close();
		entityManagerFactory.close();

	}
	
	public static void displayEveything(EntityManager entityManager)
	{
		System.out.println("--------------");
		System.out.println("Employee list :");
		// get all the objects from Employee table
		@SuppressWarnings("unchecked")
		List<Employee> listEmployee = entityManager.createQuery("SELECT e FROM Employee e").getResultList();

		if (listEmployee == null)
		{
			System.out.println("No employee found . ");
		} else
		{
			for (Employee empl : listEmployee)
			{
				System.out.println("Employee name= " + empl.getName() + ", Employee id " + empl.getEmployeeId() + ", Employee mail " + empl.getEmail());
			}
		}
		
		// get all the objects from company table
		System.out.println("--------------");
		System.out.println("Compagny list :");
		@SuppressWarnings("unchecked")
		List<Company> listCompany = entityManager.createQuery("SELECT c FROM Company c").getResultList();

		if (listCompany == null)
		{
			System.out.println("No compagny found . ");
		} else
		{
			for (Company cp : listCompany)
			{
				System.out.println("Compagny name= " + cp.getCompanyName() + ", Compagny id " + cp.getCompanyId());
			}
		}
	}
	
	public static void linkEmployeeToCompagny(int employeeId, int compagnyId, EntityManager entityManager)
	{
		Company cmp = entityManager.find(Company.class, employeeId);
		
		Employee emp = entityManager.find(Employee.class, compagnyId);	
		cmp.addEmployeeToCompagny(emp);
		entityManager.persist(cmp);
		entityManager.getTransaction().commit();
	}

	
}
