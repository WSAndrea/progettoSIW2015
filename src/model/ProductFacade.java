package model;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class ProductFacade {

	@PersistenceContext(unitName = "siw2015-unit")
	private EntityManager em;
	
	public Product createProduct(String name, String code, Float price, String description, Integer stockquantity) throws EJBTransactionRolledbackException{
		Product product = new Product(name, code, price, description, stockquantity);
		em.persist(product);
		return product;
	}
	
	public List<Product> getAllProducts() {
		CriteriaQuery<Product> query = em.getCriteriaBuilder().createQuery(Product.class);
		query.select(query.from(Product.class));
		List<Product> products = em.createQuery(query).getResultList();
		return products;
	}
	
	public Product findProduct(Long id) {
		return em.find(Product.class, id);
	}
	
	public void addProvider(Long id, Provider provider) {
		Product product = em.find(Product.class, id);
		if(product.getProviders()==null) {
			List<Provider> providers = new LinkedList<Provider>();
			providers.add(provider);
			product.setProviders(providers);
		}
		else 
			product.getProviders().add(provider);
		em.merge(product);
	}
}
