package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CustomerFacade {

	@PersistenceContext(unitName = "siw2015-unit")
	private EntityManager em;

	public Customer createCustomer(String firstName, String lastName, String email, 
			String phoneNumber, Date dateOfBirth, Address address) {
		
		Customer customer = new Customer(); // da valutare creazione di un costruttore in Customer
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setPhoneNumber(phoneNumber);
		customer.setAddress(address);
		customer.setDateOfBirth(dateOfBirth);
		Date registrationDate = new Date();
		customer.setRegistrationDate(registrationDate);
		em.persist(customer);
		return customer;
	}
	
	public Customer getCustomer(Long id) {
		Customer customer = em.find(Customer.class, id);
		return customer;
	}
	
	public void deleteCustomer(Long id) {
		Customer customer = em.find(Customer.class, id);
		em.remove(customer);
	}
	
	public void addOrder(Long id, Orders order) {
		Customer c = em.find(Customer.class, id);
		if(c.getOrders()==null) {
			List<Orders> orders = new LinkedList<Orders>();
			orders.add(order);
			c.setOrders(orders);
		}
		else
			c.getOrders().add(order);
		em.merge(c);
	}
}
