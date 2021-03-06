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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQuery(name="getAllProducts", query = "SELECT p from Product p")
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
	private Integer stockquantity;
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.MERGE})
	@JoinColumn(name = "product_code")
	private List<OrderLine> orderLines;
	@ManyToMany(mappedBy = "products", cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
	private List<Provider> providers;

	public Product(Long id, String code, String name, String description, Float price, Integer stockquantity, List<OrderLine> orderLines, List<Provider> providers) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockquantity = stockquantity;
		this.orderLines = orderLines;
		this.providers = providers;
	}

	public Product() {

	}

	public Product(String name, String code, Float price, String description, Integer stockquantity) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stockquantity = stockquantity;
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

	public Integer getStockquantity() {
		return stockquantity;
	}

	public void setStockquantity(Integer stockquantity) {
		this.stockquantity = stockquantity;
	}

	public Float getPrice() {
		return this.price;
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


