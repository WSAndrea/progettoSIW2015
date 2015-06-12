package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import exception.InvalidLoginException;

@Stateless
public class CustomerFacade {

	@PersistenceContext(unitName = "siw2015-unit")
	private EntityManager em;


	public Customer createCustomer(String firstName, String lastName, String email, String password, String phoneNumber, 
			String street,String zipcode, String country, String city, 
			String day,String month,String year) {

		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setPhoneNumber(phoneNumber);
		Address address = new Address();
		address.setCity(city);
		address.setCountry(country);
		address.setStreet(street);
		address.setZipcode(zipcode);
		customer.setAddress(address);
		@SuppressWarnings("deprecation")
		Date dateOfBirth = new Date(Integer.parseInt(year)-1900, Integer.parseInt(month)-1, Integer.parseInt(day));
		customer.setDateOfBirth(dateOfBirth);
		Date registrationDate = new Date();
		customer.setRegistrationDate(registrationDate);
		em.persist(customer);
		return customer;
	}
	public Customer loginCheck(String email, String password) throws InvalidLoginException {
		TypedQuery<Customer> query = em.createNamedQuery("customer.retrieveCustomer", Customer.class);
		query.setParameter("email", email);
		Customer customer= new Customer();
		try { 
			customer = query.getSingleResult();
		} catch (javax.persistence.NoResultException e) {
			throw new InvalidLoginException();
		}
		if(password.equals(customer.getPassword()))
			return customer;
		else
			throw new InvalidLoginException();
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
