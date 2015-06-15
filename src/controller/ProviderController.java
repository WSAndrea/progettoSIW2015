package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Product;
import model.ProductFacade;
import model.Provider;
import model.ProviderFacade;


@ManagedBean
@SessionScoped
public class ProviderController {

	private Long id;
	private Long pid;
	private String name;
	private String email;
	private String phonenumber;
	private String vatin;
	private String street;
	private String zipcode;
	private String country;
	private String city;
	private Provider provider;
	private List<Provider> providers;
	private Product product;
	private List<Product> products;

	@EJB
	private ProviderFacade providerFacade;
	@EJB
	private ProductFacade productFacade;

	public String createProvider() {
		try {
			provider = providerFacade.createProvider(name, email, phonenumber, vatin, street, zipcode, country, city);
		} catch(EJBTransactionRolledbackException e) {
			return "providerExc";
		}
		return "confirmedProvider";
	}

	public void findProductsByProvider(String id) {
		this.id = Long.parseLong(id);
		products = productFacade.findProductsByProvider(this.id);
	}

	public void retrieveAllProviders() {
		providers = providerFacade.retrieveAllProviders();
	}

	public void findProvider(String id) {
		this.id = Long.parseLong(id);
		provider = providerFacade.findProvider(this.id);
	}

	public void retrieveAllProducts() {
		this.products = productFacade.getAllProducts();
	}

	public String assignProduct(Long pid) {
		try {
			providerFacade.assignProduct(id,pid);
		} catch(EJBTransactionRolledbackException e) {
			return "assignExc";
		}
		return "confirmedAssign";
	}
	
	public void convertId(String id) {
		this.id = Long.parseLong(id);
	}
	
	public void convertPid(String pid) {
		this.pid = Long.parseLong(pid);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getVatin() {
		return vatin;
	}

	public void setVatin(String vatin) {
		this.vatin = vatin;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public ProviderFacade getProviderFacade() {
		return providerFacade;
	}

	public void setProviderFacade(ProviderFacade providerFacade) {
		this.providerFacade = providerFacade;
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

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}
}
