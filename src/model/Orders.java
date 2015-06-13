package model;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name="getOrders", query = "SELECT o FROM Orders o WHERE o.customer.id = :customer_id")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	@Temporal(TemporalType.DATE)
	private Date creationTime;
	@Column
	@Temporal(TemporalType.DATE)
	private Date evasionTime;
	@ManyToOne(cascade = {CascadeType.MERGE})
	private Customer customer;
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinColumn(name = "orders_id")
	private List<OrderLine> orderLines;

	public Orders(Long id, Date creationTime, Customer customer, List<OrderLine> orderLines) {
		super();
		this.id = id;
		this.creationTime = creationTime;
		this.customer = customer;
		this.orderLines = orderLines;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (creationTime == null) {
			if (other.creationTime != null)
				return false;
		} else if (!creationTime.equals(other.creationTime))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderLines == null) {
			if (other.orderLines != null)
				return false;
		} else if (!orderLines.equals(other.orderLines))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orders: \n" +
				"ID: " + this.id + "\n" +
				"Creation Time: " + this.creationTime + "\n" +
				"Customer ID: " + this.customer.getId() + "\n" +
				"Order Lines: " + this.orderLines.toString() + "\n";
	}

	public Orders() {

	}

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

	public Date getEvasionTime() {
		return evasionTime;
	}



	public void setEvasionTime(Date evasionTime) {
		this.evasionTime = evasionTime;
	}



	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
		/*if(!customer.getOrders().contains(this))
			customer.getOrders().add(this);*/
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}


}
