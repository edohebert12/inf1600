package Persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import Model.Article;

public class PArticle {

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

	public Article read (String id) {
		return manager.find(Article.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Article> read() {
		return manager.createQuery("from Article").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> readQuery(String query) {
		return manager.createQuery(query).getResultList();
	}
	
	public Query createQuery(String q) {
		return manager.createQuery(q);
	}
	
	@Transactional
	public void remove(List<Article> arts) {
		EntityTransaction t = manager.getTransaction();
		for (Article i : arts) {
			t.begin();
			manager.remove(i);
			t.commit();
		}
	}
	
	public void close() {
		manager.close();
		managerFactory.close();
	}

}
