package com.jdbSpringMVC03.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.jdbSpringMVC03.daoi.EmployeeDAOI;
import com.jdbSpringMVC03.entities.Employee;

public class EmployeeService implements EmployeeDAOI {

	@Override
	public boolean addEmployee(Employee emp) {
		boolean result = true;
		// 1. Factory
		EntityManagerFactory enMaFact = Persistence.createEntityManagerFactory("jdbSpringMVC03");
		// 2. Manager
		EntityManager enManager = enMaFact.createEntityManager();
		// 3. Transaction being
		try {
			enManager.getTransaction().begin();
			// 4. persist
			enManager.persist(emp);
//			5. commit transaction
			enManager.getTransaction().commit();
		} catch (PersistenceException e) {
			result = false;
			e.printStackTrace();
		} finally {
//			6. close manager
//			7.close factory
			enManager.close();
			enMaFact.close();
		}
		return result;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// 1. Factory
		EntityManagerFactory enMaFact = Persistence.createEntityManagerFactory("jdbSpringMVC03");
		// 2. Manager
		EntityManager enManager = enMaFact.createEntityManager();

		Query query = enManager.createNamedQuery("GetAllEmployees");
		List<Employee> employeeList = query.getResultList();
		enManager.close();
		enMaFact.close();
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee foundEmployee = new Employee();
		// 1. Factory
		EntityManagerFactory enMaFact = Persistence.createEntityManagerFactory("jdbSpringMVC03");
		// 2. Manager
		EntityManager enManager = enMaFact.createEntityManager();
		try {
			foundEmployee = enManager.find(Employee.class, id);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			
		} finally {
			enManager.close();
			enMaFact.close();
		}
		return foundEmployee;
	}

	@Override
	public boolean removeEmployeeByIdService(int id) {

		boolean result = true;
		EntityManagerFactory enMaFact = Persistence.createEntityManagerFactory("jdbSpringMVC03");
		// 2. Manager
		EntityManager enManager = enMaFact.createEntityManager();
		try {
			enManager.getTransaction().begin();
			Employee foundEmp = enManager.find(Employee.class, id);
			enManager.remove(foundEmp);
			enManager.getTransaction().commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			result = false;
		} finally {
			enManager.close();
			enMaFact.close();
		}

		return result;
	}

	@Override
	public boolean updatedEmployee(Employee emp) {
		boolean result = true;		
		EntityManagerFactory enMaFact = Persistence.createEntityManagerFactory("jdbSpringMVC03");
		EntityManager enManager = enMaFact.createEntityManager();
		try {
			enManager.getTransaction().begin();
			Employee foundEmp = enManager.find(Employee.class, emp.getId());
			foundEmp.setFirstName(emp.getFirstName());
			foundEmp.setLastName(emp.getLastName());
			foundEmp.setEmail(emp.getEmail());
			enManager.getTransaction().commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			result = false;
		} finally {
			enManager.close();
			enMaFact.close();
		}
		
		return result;
		
	}
}
