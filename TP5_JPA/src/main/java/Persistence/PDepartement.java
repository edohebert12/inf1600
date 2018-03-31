package Persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Model.Departement;

public class PDepartement {

	private static EntityManagerFactory managerFactory = null;
	private static EntityManager manager = null;

	public void setUp () {
		if (managerFactory == null) {
			managerFactory = Persistence.
					createEntityManagerFactory("TP5");
		}
		if (manager == null) {
			manager = managerFactory.createEntityManager();
		}
	}

	public Departement read (String id) {
		return manager.find(Departement.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Departement> read() {
		return manager.createQuery("from Departement").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Departement> readQuery(String query) {
		return manager.createQuery(query).getResultList();
	}
	
	public void updateQuery(String q) {
		EntityTransaction t = manager.getTransaction();
		t.begin();
		manager.createQuery(q).executeUpdate();
		t.commit();
	}
	
	public void insertQuery(Departement d) {
		EntityTransaction t = manager.getTransaction();
		t.begin();
		try {
			manager.persist(d);
			t.commit();
		} catch (Exception e) {
			System.out.println("Departement already exists in current session");
			t.rollback();
		}
	}
	
	public void close() {
		manager.close();
		managerFactory.close();
	}
}
