package model;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;



import exception.InvalidLoginException;

@Stateless
public class AdminFacade {

	@PersistenceContext(unitName = "siw2015-unit")
	private EntityManager em;

	public Admin createAdmin(String username, String email, String password) {
		Admin admin = new Admin(username,email,password);
		em.persist(admin);
		return admin;
	}

	public Admin loginCheck(String username, String password) throws InvalidLoginException {
		TypedQuery<Admin> query = em.createNamedQuery("admin.retrieveAdmin", Admin.class);
		query.setParameter("username", username);
		Admin admin = new Admin();
		try { 
			admin = query.getSingleResult();
		} catch (javax.persistence.NoResultException e) {
			throw new InvalidLoginException();
		}
		if(password.equals(admin.getPassword()))
			return admin;
		else
			throw new InvalidLoginException();
	}
}
