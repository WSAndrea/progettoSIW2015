package model;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

	public Product getProduct(Long id) {
		Product product = em.find(Product.class, id);
		return product;
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
	
	public void addOrderline(Long id, OrderLine orderline) {
		Product product = em.find(Product.class, id);
		if(product.getOrderLines()==null) {
			List<OrderLine> orderlines = new LinkedList<OrderLine>();
			orderlines.add(orderline);
			product.setOrderLines(orderlines);
		}
		else 
			product.getOrderLines().add(orderline);
		em.merge(product);
	}
	
	public Product findProductFromOrderline(Long id) {
		TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p JOIN p.orderLines ol WHERE ol.id  = :orderlineid", Product.class);
		query.setParameter("orderlineid", id);
		Product product = query.getSingleResult();
		return product;
	}
	
}
