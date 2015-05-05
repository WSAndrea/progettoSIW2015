package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique=true,nullable=false)
	private String code;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private Float price;
	@Column
	private Integer quantity;
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name = "product_id")
	private List<OrderLine> orderLines;
	@ManyToMany(mappedBy = "products", cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
	private List<Provider> providers;

	public Product(Long id, String code, String name, String description, Float price, Integer quantity, List<OrderLine> orderLines, List<Provider> providers) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.orderLines = orderLines;
		this.providers = providers;
	}

	public Product() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", description="
				+ description + ", price=" + price + ", orderLines="
				+ orderLines + ", providers=" + providers + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Product p = (Product)obj;
		if(this.code.equals(p.getCode()))
			return true;
		return false;
	}



}


