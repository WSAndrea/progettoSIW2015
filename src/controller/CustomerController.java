package controller;

<<<<<<< HEAD
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;




import model.Customer;
import model.CustomerFacade;
import model.Orders;



@ManagedBean
public class CustomerController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String day;
	private String month;
	private String year;
	private String street;
	private String zipcode;
	private String country;
	private String city;
	private Customer customer;
	private List<Orders> orders;

	@EJB
	private CustomerFacade customerFacade;

	public String createCustomer() {
		try {
			this.customer = customerFacade.createCustomer(firstName, lastName, email,
					phoneNumber, street, zipcode, country, 
					city, day, month, year);
		}
		catch(EJBTransactionRolledbackException e) {
			return "customerExc";
		}
		return "confirmedCustomer";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public CustomerFacade getCustomerFacade() {
		return customerFacade;
	}

	public void setCustomerFacade(CustomerFacade customerFacade) {
		this.customerFacade = customerFacade;
=======
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;




import model.Customer;
import model.CustomerFacade;
import model.Orders;



@ManagedBean
@SessionScoped
public class CustomerController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String giornoDiNascita;
	private String meseDiNascita;
	private String annoDiNascita;
	private Date registrationDate;
	private String via;
	private String numeroCivico;
	private Integer cap;
	private String state;
	private Customer customer;
	private List<Orders> orders;
	
	
	@EJB
	private  CustomerFacade  customerFacade;

	public String createCustomer() {
		try {
			this.customer = customerFacade.createCustomer(firstName,  lastName,  email, 
				 phoneNumber, via,numeroCivico, cap, state,giornoDiNascita, meseDiNascita, annoDiNascita);
		}
		catch(EJBTransactionRolledbackException e) {
			return "productExc";
		}
		return "confirmedProduct";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGiornoDiNascita() {
		return giornoDiNascita;
	}

	public void setGiornoDiNascita(String giornoDiNascita) {
		this.giornoDiNascita = giornoDiNascita;
	}

	public String getMeseDiNascita() {
		return meseDiNascita;
	}

	public void setMeseDiNascita(String meseDiNascita) {
		this.meseDiNascita = meseDiNascita;
	}

	public String getAnnoDiNascita() {
		return annoDiNascita;
	}

	public void setAnnoDiNascita(String annoDiNascita) {
		this.annoDiNascita = annoDiNascita;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(String numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public Integer getCap() {
		return cap;
	}

	public void setCap(Integer cap) {
		this.cap = cap;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
>>>>>>> refs/remotes/origin/master
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}


}
