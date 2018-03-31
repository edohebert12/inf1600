package Persistence;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class AbstractPersistence<TYPE> {
	private Class<TYPE> clazz;
	
	private SessionFactory sessionFactory = null;
	private Session currentSession = null;
	
	public AbstractPersistence(Class<TYPE> c) {
		this.clazz = c;
	}

	public void setUp () {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("./hibernate.cfg.xml")
				.build();
		try { 
			sessionFactory = new MetadataSources(registry)
					.buildMetadata()
					.buildSessionFactory();
		} catch (Exception ex) {
			System.out.println("setup");
			System.out.println(ex.getMessage());
			StandardServiceRegistryBuilder.destroy(registry); 
		}

	}

	public void ouvrirSession() {
		try {
			currentSession = sessionFactory.openSession();
		} catch (HibernateException e) {
			System.out.println("Could not open session");
			System.out.println(e.getMessage());
		} catch (Exception f) {
			System.out.println("Other exeption open session");
			System.out.println(sessionFactory);
		}

	}

	public TYPE read(Object id) {
		return currentSession.find(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<TYPE> read() {
		return currentSession.createQuery("from " + clazz.getName()).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TYPE> readNativeQuery(String q) {
		return currentSession.createNativeQuery(q).getResultList();
	}

	public void update(TYPE c) {
		Transaction tx = currentSession.getTransaction();
		try {
			tx.begin();
			currentSession.update(c);
			tx.commit();
			System.out.println("Update: " + c.toString());
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	public void remove(TYPE c) {
		Transaction tx = currentSession.getTransaction();
		try {
			tx.begin();
			currentSession.remove(c);
			tx.commit();
			System.out.println("Remove: " + c.toString());
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	public void add(TYPE c) {
		Transaction tx = currentSession.getTransaction();
		try {
			tx.begin();
			currentSession.persist(c);
			tx.commit();
			System.out.println("Add: " + c.toString());
		} catch (Exception e) {
			tx.rollback();
		}
	}

	public void fermerSession() {
		/* Instructions … */
		currentSession.close();

	}
	public void close() {
		sessionFactory.close();
	}


}
