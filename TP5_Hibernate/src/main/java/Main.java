import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Model.Article;
import Model.Chercheur;
import Model.Departement;
import Model.Equipe;
import Persistence.AbstractPersistence;

public class Main {

	static AbstractPersistence<Chercheur> c = new AbstractPersistence<Chercheur>(Chercheur.class);
	static AbstractPersistence<Departement> d = new AbstractPersistence<Departement>(Departement.class);
	static AbstractPersistence<Article> a = new AbstractPersistence<Article>(Article.class);
	static AbstractPersistence<Equipe> e = new AbstractPersistence<Equipe>(Equipe.class);
	
	static List<Chercheur> chercheurs;
	static List<Departement> departements;
	static List<Article> articles;
	static List<Equipe> equipes;
	
	public static void readAll() {
		departements = d.read();
		chercheurs = c.read();
		articles = a.read();
		equipes = e.read();
	}
	
	public static void q1() {
		for (Departement e : departements) {
			if(e.getNom().equalsIgnoreCase("Informatique")) {
				System.out.println(e.toString());				
			}
		}
	}

	public static void q2() {
		for (Departement e : departements) {
			System.out.println(e.toString());
		}
	}

	public static void q3() {
		for (Chercheur copin : chercheurs) {
			System.out.println(copin.toString());
		}
	}

	public static void q4() {
		for(Chercheur copin : chercheurs) {
			System.out.println(copin);
			for(Article article : articles) {
				if(article.getAuteur().equalsIgnoreCase(copin.getMatricule())) {
					System.out.println("\t" + article);
				}
			}
		}
	}

	public static void q5() {
		for (Chercheur chr : chercheurs) {
			if (chr.getMatricule().equals("M22556")) {
				System.out.println(chr);
			}
		}
		for (Article art : articles) {
			if (art.getAuteur().equals("M22556")) {
				System.out.println(art);
			}
		}
	}

	public static void q6() {
		for (Article art : articles) {
			if (art.getDepartement().getNom().equals("Mathematiques")) {
				a.remove(art);
				break;
			}
		}
		readAll();
	}

	public static void q7() {
		for (Article art : articles) {
			if (art.getSoumisLe().equals(new Timestamp(1179288000000L))) {
				for (Chercheur chr : chercheurs) {
					if (chr.getMatricule().equals(art.getAuteur())) {
						c.remove(chr);
						break;
					}
				}
				break;
			}
		}
		readAll();
	}

	public static void q8() {
		for (Departement dep : departements) {
			if (dep.getNom().equals("Physique")) {
				dep.setAdresse("Quebec");
				d.update(dep);
			}
		}
		readAll();
	}

	public static void q9() {
		ArrayList<String> equipesMath = new ArrayList<String>();
		for (Equipe eq : equipes) {
			if (eq.getDep().getNom().equals("Mathematiques")) {
				equipesMath.add(eq.getNom());
			}
		}
		for (Chercheur chr : chercheurs) {
			if (equipesMath.contains(chr.getEquipe().getNom())) {
				chr.setPosition("postdoc");
				c.update(chr);
			}
		}
		readAll();
	}

	public static void q10() {
		Departement dep = new Departement();
		dep.setAdresse("Gaspesie");
		dep.setNom("Medecine");
		dep.setDateCreation(new Date(1519880400000L));
		dep.setTelephone("123-456-7890");
		d.add(dep);
		readAll();
	}

	public static void q11() {
		Equipe eq = new Equipe();
		eq.setNom("Pediatre");
		eq.setNbrProjets(123);
		eq.setDateCreation(new Date(1519880400000L));
		eq.setResponsable("Genghis Khan");
		for (Departement dep : departements) {
			if (dep.getNom().equals("Medecine")) {
				eq.setDep(dep);
				break;
			}
		}
		e.add(eq);
		readAll();
	}
	
	public static void main(String[] args) {
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

		d.setUp();
		d.ouvrirSession(); // U2
		c.setUp();
		c.ouvrirSession(); // U2
		a.setUp();
		a.ouvrirSession(); // U2
		e.setUp();
		e.ouvrirSession(); // U2
		
		readAll();
		
		System.out.println("QUESTION 1");
	    q1();
		System.out.println("\nQUESTION 2");
		q2();
		System.out.println("\nQUESTION 3");
		q3();
	    System.out.println("\nQUESTION 4");
	    q4();
	    System.out.println("\nQUESTION 5");
	    q5();
	    System.out.println("\nQUESTION 6");
	    q6();
	    System.out.println("\nQUESTION 7");
	    q7();
	    System.out.println("\nQUESTION 8");
	    q8();
	    System.out.println("\nQUESTION 9");
	    q9();
	    System.out.println("\nQUESTION 10");
	    q10();
	    System.out.println("\nQUESTION 11");
	    q11();
	    
	    d.fermerSession();
	    d.close();
	    c.fermerSession();
	    c.close();
	    a.fermerSession();
	    a.close();
	    e.fermerSession();
	    e.close();
	}
	
}
