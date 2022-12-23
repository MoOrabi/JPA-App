package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AddressId implements Serializable {


	private static final long serialVersionUID = 1L;

	public AddressId() {
		
	}
	public AddressId(int streetNumber, String streetName, String city, String country) {
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.country = country;
	}


	@Column(name = "street_number")
	int streetNumber;
	
	@Column(name = "street_name")
	String streetName;
	
	String city;
	
	String country;

	public int getStreetNumber() {
		return streetNumber;
	}


	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}


	public String getStreetName() {
		return streetName;
	}


	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
