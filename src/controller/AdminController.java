package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import exception.InvalidLoginException;
import model.Admin;
import model.AdminFacade;
import model.Orders;
import model.OrdersFacade;

@ManagedBean
@SessionScoped
public class AdminController {

	private Long id;
	private Admin admin;
	private String email;
	private String username;
	private String password;
	private List<Admin> adminlist;
	private List<Orders> orders;

	@EJB
	private AdminFacade adminFacade;
	@EJB
	private OrdersFacade orderFacade;

	public String authenticate() {
		try {
			this.admin = adminFacade.loginCheck(this.username, this.password);
		} catch(InvalidLoginException e) {
			return "errlog";
		}
		return "adminPanel";
	}

	public void fetchAllOrders() {
		this.setOrders(orderFacade.getAllOrders());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Admin> getAdminlist() {
		return adminlist;
	}

	public void setAdminlist(List<Admin> adminlist) {
		this.adminlist = adminlist;
	}

	public AdminFacade getAdminFacade() {
		return adminFacade;
	}

	public void setAdminFacade(AdminFacade adminFacade) {
		this.adminFacade = adminFacade;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
}
