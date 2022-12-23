package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department implements Serializable {
	
	public Department() {

	}
	
	
	
	public Department(String departmentName) {
		this.departmentName = departmentName;
	}


	@Id
	@Column(name = "department_name")
	String departmentName;




	public String getDepartmentName() {
		return departmentName;
	}



	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}



	@Override
	public String toString() {
		return departmentName;
	}
	

	
}
