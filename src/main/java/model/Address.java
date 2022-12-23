package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import javax.persistence.ManyToOne;

@Entity
@Table(name = "address")
public class Address {

	@EmbeddedId
	AddressId addressId;
	
	@ManyToOne(cascade = {CascadeType.DETACH,
			  CascadeType.PERSIST,
			  CascadeType.MERGE,
			  CascadeType.REFRESH})
	@JoinColumn(name = "employee", referencedColumnName = "id")
	Employee employee;
	
	public Address() {

	}
	
	
	public Address(AddressId addressId) {
		this.addressId=addressId;
	}


	public AddressId getAddressId() {
		return addressId;
	}


	public void setAddressId(AddressId addressId) {
		this.addressId = addressId;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	
	
	
}
