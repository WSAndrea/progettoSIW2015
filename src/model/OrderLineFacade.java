package model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class OrderLineFacade {

	@PersistenceContext(unitName="siw2015-unit")
	private EntityManager em;

	public List<OrderLine> retrieveOrderlines(Long orderid) {
		TypedQuery<OrderLine> query = em.createQuery("SELECT ol from Orders o INNER JOIN o.orderLines ol WHERE o.id = :orderid", OrderLine.class);
		query.setParameter("orderid", orderid);
		List<OrderLine> orderlines = query.getResultList();
		return orderlines;
	}

}
