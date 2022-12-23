package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeegroup")
public class Group implements Serializable {

	public Group() {

	}
	
	
	
	public Group(String groupName) {
		this.groupName = groupName;
	}



	@Id
	@Column(name = "group_name")
	String groupName;

	public String getGroupName() {
		return groupName;
	}



	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}



	@Override
	public String toString() {
		return  groupName;
	}
	
	
	
}
