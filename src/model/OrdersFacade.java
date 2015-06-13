package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class OrdersFacade {

	@PersistenceContext(unitName = "siw2015-unit")
	private EntityManager em;

	public Orders createOrder(Date creationTime,Customer customer,List<OrderLine> orderLines) throws EJBTransactionRolledbackException{
		Orders order = new Orders(creationTime,customer, List<OrderLine> orderLines);
		em.persist(order);
		return order;
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

	public void addOrderLines(Long id, OrderLine orderLine) {
		Orders order = em.find(Orders.class, id);
		if(order.getOrderLines()==null) {
			List<OrderLine> orderLines = new LinkedList<OrderLine>();
			orderLines.add(orderLine);
			order.setOrderLines(orderLines);
		}
		else 
			order.getOrderLines().add(orderLine);
		em.merge(order);
	}
}
