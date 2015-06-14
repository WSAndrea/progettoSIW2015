package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.OrderLine;
import model.OrdersFacade;
import model.Product;
import model.ProductFacade;
import model.Provider;

@ManagedBean
@SessionScoped
public class ProductController {

	//@ManagedProperty(value="#{param.id}")
	private Long id;
	//@ManagedProperty(value="#{param.oid}")
	private Long oid;
	private String code;
	private String name;
	private String description;
	private Float price;
	private Integer stockquantity;
	private List<OrderLine> orderLines;
	private List<Provider> providers;
	private Product product;
	private List<Product> products;
	private OrderLine orderline;
	private Integer quantity;

	@EJB
	private ProductFacade productFacade;
	@EJB
	private OrdersFacade ordersFacade;

	public String createProduct() {
		try {
			this.product = productFacade.createProduct(name, code, price, description, stockquantity);
		}
		catch(EJBTransactionRolledbackException e) {
			return "productExc";
		}
		return "confirmedProduct";
	}

	public String retrieveAllProducts() {
		this.products = productFacade.getAllProducts();
		return "catalogo";
	}

	public void findProduct(String id) {
		this.id = Long.parseLong(id);
		this.product = productFacade.getProduct(this.id);
	}
	
	public void findOid(String oid) {
		this.oid = Long.parseLong(oid);
	}

	public String confirmOrderline() {
		this.orderline = new OrderLine();
		this.orderline.setQuantity(this.quantity);
		this.orderline.setUnitprice(this.product.getPrice());
		productFacade.addOrderline(this.id, this.orderline);
		Long lineid = this.orderline.getId();
		ordersFacade.addOrderLines(oid, lineid);
		return "confirmedOrderline";
	}

	public String goBack() {
		return "newOrder";
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getStockquantity() {
		return stockquantity;
	}

	public void setStockquantity(Integer stockquantity) {
		this.stockquantity = stockquantity;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public ProductFacade getProductFacade() {
		return productFacade;
	}

	public void setProductFacade(ProductFacade productFacade) {
		this.productFacade = productFacade;
	}

	public OrderLine getOrderline() {
		return orderline;
	}

	public void setOrderline(OrderLine orderline) {
		this.orderline = orderline;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}
}
