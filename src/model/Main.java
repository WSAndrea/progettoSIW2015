package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("siw2015-unit");
		EntityManager m = f.createEntityManager();
		EntityTransaction t = m.getTransaction();
		t.begin();
		t.commit();
		m.close();
		f.close();
	}
}