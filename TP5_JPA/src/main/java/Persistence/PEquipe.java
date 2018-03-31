package Persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Model.Equipe;;

public class PEquipe {

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

	public Equipe read (String id) {
		return manager.find(Equipe.class, id);
	}
	
	public List<Equipe> read() {
		return manager.createQuery("from Equipe").getResultList();
	}
	
	public List<Equipe> readQuery(String query) {
		return manager.createQuery(query).getResultList();
	}
	
	public void insertQuery(Equipe d) {
		EntityTransaction t = manager.getTransaction();
		t.begin();
		try {
			manager.persist(d);
		} catch (Exception e) {
			System.out.println("Equipe already exists in current session");
			t.rollback();
			return;
		}
		t.commit();
	}
	
	public void close() {
		manager.close();
		managerFactory.close();
	}

}
