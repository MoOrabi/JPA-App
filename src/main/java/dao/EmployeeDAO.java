package dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import model.Department;
import model.Employee;
import model.Group;

public class EmployeeDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("db");
    EntityManager em= emf.createEntityManager();
    EntityTransaction tx=em.getTransaction();
	
	@Transactional
	public void addEmployee(Employee employee) {
		tx.begin();
		if(em.find(Department.class, employee.getDepartment().toString())==null) {
			em.persist(employee.getDepartment());
		}
		System.out.println(em.find(Group.class, employee.getGroup().toString()));
		if(em.find(Group.class, employee.getGroup().toString())==null) {
				em.persist(employee.getGroup());
		}
		em.persist(employee);		
		tx.commit();
	}
	@Transactional
	public void updateEmployee(int id,Employee employee) {
		tx.begin();
		Employee updatedEmployee=em.find(Employee.class, id);
		updatedEmployee.setName(employee.getName());
		updatedEmployee.setDepartment(employee.getDepartment());
		updatedEmployee.setAddress(employee.getAddress());
		updatedEmployee.setGroup(employee.getAllGroups());
		em.persist(updatedEmployee);		
		tx.commit();
	}
	@Transactional
	public Employee getEmployeeById(int id) {
		tx.begin();
		Employee employee=em.find(Employee.class, id);	
		tx.commit();
		System.out.println(employee);
		return employee;
	}
	
	@Transactional
	public List<Employee> getAllEmployees() {
		tx.begin();
		List<Employee> employees=em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList(); 
		tx.commit();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		
		return employees;
	}
	@Transactional
	public void removeEmployeeById(int id) {
		Employee employee=em.find(Employee.class, id);
		tx.begin();
		em.remove(employee);		
		tx.commit();
	}
}
