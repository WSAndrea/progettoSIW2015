package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


<<<<<<< HEAD


=======
>>>>>>> refs/remotes/origin/master
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CustomerFacade {

	@PersistenceContext(unitName = "siw2015-unit")
<<<<<<< HEAD
	private EntityManager em;


	public Customer createCustomer(String firstName, String lastName, String email, String phoneNumber, 
			String street,String zipcode, String country, String city, 
			String day,String month,String year) {

		Customer customer = new Customer();
=======
	private static EntityManager em;
	
	
	public  Customer createCustomer(String firstName, String lastName, String email, 
			String phoneNumber,String via,String numeroCivico,Integer cap,String state,String giornoDiNascita,String meseDiNascita,String annoDiNascita) {
		
		Customer customer = new Customer(); // da valutare creazione di un costruttore in Customer
>>>>>>> refs/remotes/origin/master
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setPhoneNumber(phoneNumber);
<<<<<<< HEAD
		Address address = new Address();
		address.setCity(city);
		address.setCountry(country);
		address.setStreet(street);
		address.setZipcode(zipcode);
		customer.setAddress(address);
		@SuppressWarnings("deprecation")
		Date dateOfBirth = new Date(Integer.parseInt(year)-1900, Integer.parseInt(month)-1, Integer.parseInt(day));
		customer.setDateOfBirth(dateOfBirth);
=======
		customer.setVia(via);
		customer.setNumeroCivico(numeroCivico);
		customer.setCap(cap);
		customer.setState(state);
		customer.setGiornoDiNascita(giornoDiNascita);
		customer.setMeseDiNascita(meseDiNascita);
		customer.setAnnoDiNascita(annoDiNascita);
>>>>>>> refs/remotes/origin/master
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

<<<<<<< HEAD

=======
	
>>>>>>> refs/remotes/origin/master
}
