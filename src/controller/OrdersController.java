package controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;






import model.Customer;
import model.OrderLine;
import model.Orders;
import model.OrdersFacade;

@ManagedBean

public class OrdersController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private Date creationTime;
	private Customer customer;
	private List<OrderLine> orderLines;
	private Orders order;
	private List<Orders> orders;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public OrdersFacade getOrderFacade() {
		return orderFacade;
	}

	public void setOrderFacade(OrdersFacade orderFacade) {
		this.orderFacade = orderFacade;
	}

	@EJB
	private OrdersFacade orderFacade;

	public String createOrder() {
		try {
			this.order = orderFacade.createOrder(creationTime,customer,orderLines);
		}
		catch(EJBTransactionRolledbackException e) {
			return "orderExc";
		}
		return "confirmedOrder";
	}

	public String retrieveAllOrders() {
		this.orders = orderFacade.getAllOrders();
		return "riepilogoOrdini";
	}

	public String findOrder() {
		this.order = orderFacade.getOrder(this.id);
		System.out.println("TEST PROVA TEST PROVA");
		return "order";
	}

	public void findOrder(String id) {
		this.id = Long.parseLong(id);
		this.order = orderFacade.getOrder(this.id);
	}
}