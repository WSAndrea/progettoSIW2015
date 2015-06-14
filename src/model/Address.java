package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity//ciao vvvvvv
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"street","city"}))
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String street;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String zipcode;
	@Column
	private String country;

	public Address(Long id, String street, String city, String state,
			String zipcode, String country) {
		this.id = id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
	}

	public Address() {

	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return street + ", " + city + " " + ", " + zipcode + " - " + country;
	}

	@Override
	public boolean equals(Object obj) {
		Address a = (Address)obj;
		if(this.street.equals(a.getStreet()) && this.city.equals(a.getCity()))
			return true;
		return false;
	}

}
