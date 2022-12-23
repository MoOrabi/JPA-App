package model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee1")
public class Employee {
	
	public Employee() {

	}
	public Employee(String name, Department department, Set<Address> address, List<Group> group) {
		this.name = name;
		this.department = department;
		this.address = address;
		this.group = group;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String name;
	
	@OneToOne 
	@JoinColumn(name = "department", referencedColumnName = "department_name")
	Department department;
	
	@OneToMany (cascade = { CascadeType.ALL })
	@JoinColumn(name = "employee", referencedColumnName = "id")
	Set<Address> address;
	
	@ManyToMany 
    @JoinTable(
            name = "EmployeeGroups", 
            joinColumns = { 
            		@JoinColumn(name = "employee_id") }, 
            inverseJoinColumns = { @JoinColumn(name = "group_name") }
        )
	List<Group> group;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public Group getGroup() {
		return group.get(0);
	}
	
	public List<Group> getAllGroups() {
		return group;
	}

	public void setGroup(List<Group> group) {
		this.group = group;
	}
	
}
