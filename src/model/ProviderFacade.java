package model;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class ProviderFacade {

	@PersistenceContext(unitName="siw2015-unit")
	private EntityManager em;

	public Provider createProvider(String name, String email, String phonenumber, String vatin,
			String street, String zipcode, String country, String city) throws EJBTransactionRolledbackException {
		Provider provider = new Provider();
		provider.setName(name);
		provider.setEmail(email);
		provider.setPhoneNumber(phonenumber);
		provider.setVatin(vatin);
		Address address = new Address();
		address.setCity(city);
		address.setCountry(country);
		address.setStreet(street);
		address.setZipcode(zipcode);
		provider.setAddress(address);
		em.persist(provider);
		return provider;
	}

	public List<Provider> retrieveAllProviders() {
		CriteriaQuery<Provider> query = em.getCriteriaBuilder().createQuery(Provider.class);
		query.select(query.from(Provider.class));
		List<Provider> providers = em.createQuery(query).getResultList();
		return providers;
	}

	public Provider findProvider(Long id) {
		Provider provider = em.find(Provider.class, id);
		return provider;
	}

	public void assignProduct(Long pid, Long id) throws EJBTransactionRolledbackException {
		Provider provider = em.find(Provider.class, pid);
		Product product = em.find(Product.class, id);
		if(product.getProviders()==null) {
			List<Provider> providers = new LinkedList<Provider>();
			providers.add(provider);
			product.setProviders(providers);
		}
		else
			product.getProviders().add(provider);
		if(provider.getProducts()==null) {
			List<Product> products = new LinkedList<Product>();
			products.add(product);
			provider.setProducts(products);
		}
		else
			provider.getProducts().add(product);
		em.merge(provider);
	}
}
