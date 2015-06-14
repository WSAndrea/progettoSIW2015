package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import exception.InvalidLoginException;
import model.Customer;
import model.CustomerFacade;
import model.OrderLine;
import model.OrderLineFacade;
import model.Orders;
import model.OrdersFacade;



@ManagedBean
@SessionScoped
public class CustomerController {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
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
	private List<OrderLine> orderlines;
	private Orders order;

	@EJB
	private CustomerFacade customerFacade;
	@EJB
	private OrdersFacade ordersFacade;
	@EJB
	private OrderLineFacade orderlineFacade;

	public String createCustomer() {
		try {
			this.customer = customerFacade.createCustomer(firstName, lastName, email,password,
					phoneNumber, street, zipcode, country, 
					city, day, month, year);
		}
		catch(EJBTransactionRolledbackException e) {
			return "customerExc";
		}
		return "confirmedCustomer";
	}

	public String createOrder() {
		this.order = ordersFacade.createOrder(this.customer);
		customerFacade.addOrder(this.customer.getId(), this.order);
		return "newOrder";
	}

	public String confirmOrder() {
		ordersFacade.confirmOrder(this.order);
		return "confirmedOrder";
	}

	public String cancelOrder() {
		ordersFacade.deleteOrder(this.order.getId());
		return "customerPanel";
	}

	public String authenticate() {
		try {
			this.customer =  customerFacade.loginCheck(this.email, this.password);
		} catch(InvalidLoginException e) {
			return "errlog";
		}
		return "customerPanel";
	}
	
	public String retrieveAllOrders() {
		this.orders = ordersFacade.retrieveCustomerOrders(this.customer.getId());
		return "orderList";
	}
	
	public void retrieveOrderlines(String id) {
		Long oid = Long.parseLong(id);
		this.orderlines = orderlineFacade.retrieveOrderlines(oid);
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public List<OrderLine> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(List<OrderLine> orderlines) {
		this.orderlines = orderlines;
	}

}
