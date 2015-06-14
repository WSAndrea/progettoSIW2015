package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class OrdersFacade {

	@PersistenceContext(unitName = "siw2015-unit")
	private EntityManager em;

	public Orders createOrder(Customer customer) throws EJBTransactionRolledbackException {
		Orders order = new Orders();
		List<OrderLine> orderlines = new LinkedList<OrderLine>();
		order.setCustomer(customer);
		order.setOrderLines(orderlines);
		order.setCreationTime(new Date());
		em.persist(order);
		return order;
	}
	
	public List<Orders> retrieveCustomerOrders(Long customerid) {
		TypedQuery<Orders> query = em.createNamedQuery("orders.retrieveCustomerOrders", Orders.class);
		query.setParameter("customerid", customerid);
		List<Orders> orders = query.getResultList();
		return orders;
	}
	
	public void confirmOrder(Orders order) {
		em.merge(order);
	}
	
	public void deleteOrder(Long id) {
		Orders order = em.find(Orders.class, id);
		em.remove(order);
	}

	public List<Orders> getAllOrders() {
		CriteriaQuery<Orders> query = em.getCriteriaBuilder().createQuery(Orders.class);
		query.select(query.from(Orders.class));
		List<Orders> orders = em.createQuery(query).getResultList();
		return orders;
	}

	public Orders getOrder(Long id) {
		Orders order = em.find(Orders.class, id);
		return order;
	}

	public void addOrderLines(Long id, Long lineid) {
		Orders order = em.find(Orders.class, id);
		OrderLine orderline = em.find(OrderLine.class, lineid);
		if(order.getOrderLines()==null) {
			List<OrderLine> orderLines = new LinkedList<OrderLine>();
			orderLines.add(orderline);
			order.setOrderLines(orderLines);
		}
		else 
			order.getOrderLines().add(orderline);
		em.merge(order);
	}
}
