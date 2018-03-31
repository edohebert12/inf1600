package Persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import Model.Article;
import Model.Chercheur;
import Model.Departement;

public class PChercheur {

	private static EntityManagerFactory managerFactory = null;
	private static EntityManager manager = null;

	public void setUp () {
		if (managerFactory == null) {
			try {
				managerFactory = Persistence.
						createEntityManagerFactory("TP5");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		if (manager == null) {
			manager = managerFactory.createEntityManager();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Chercheur> read() {
		return manager.createQuery("from PChercheur").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Chercheur> readQuery(String query) {
		return manager.createQuery(query).getResultList();
	}
	
	public Chercheur read (String id) {
		return manager.find(Chercheur.class, id);
	}
	
	@Transactional
	public void remove(List<Chercheur> chr) {
		EntityTransaction t = manager.getTransaction();
		for (Chercheur c : chr) {
			t.begin();
			manager.remove(c);
			t.commit();
		}
	}
	
	public void updateQuery(String q) {
		EntityTransaction t = manager.getTransaction();
		t.begin();
		manager.createQuery(q).executeUpdate();
		t.commit();
	}
	
	public void close() {
		manager.close();
		managerFactory.close();
	}

}
