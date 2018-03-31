import Persistence.PChercheur;
import Persistence.PDepartement;
import Persistence.PEquipe;
import Persistence.PArticle;

import Model.Chercheur;
import Model.Departement;
import Model.Equipe;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import Model.Article;

public class Main {
	static PDepartement d = new PDepartement();
	static PChercheur c = new PChercheur();
	static PArticle a = new PArticle();
	static PEquipe e = new PEquipe();

	static void q1() {
		ArrayList<Departement> deps = (ArrayList<Departement>)d.readQuery("from Departement d where d.nom = 'Informatique'");
		for (Departement dep : deps) {
			System.out.println(dep);
		}

	}

	static void q2() {
		ArrayList<Departement> deps = (ArrayList<Departement>)d.readQuery("from Departement");
		for (Departement dep : deps) {
			System.out.println(dep);
		}
	}

	static void q3() {
		ArrayList<Chercheur> chrs = (ArrayList<Chercheur>)c.readQuery("from Chercheur");
		for (Chercheur copin : chrs) {
			System.out.println(copin);
		}
	}

	static void q4() {
		ArrayList<Chercheur> chrs = (ArrayList<Chercheur>)c.readQuery("from Chercheur");

		for (Chercheur copin : chrs) {
			ArrayList<Article> articles = (ArrayList<Article>)a.readQuery("from Article a where a.auteur = '" + copin.getMatricule() + "'");
			if (articles.size() == 0) {
				System.out.println(copin);
			}
			for(Article article : articles) {
				System.out.println(article);
			}
		}
	}

	static void q5() {
		ArrayList<Chercheur> chrs = (ArrayList<Chercheur>)c.readQuery("from Chercheur c where c.matricule = 'M22556'");
		ArrayList<Article> articles = (ArrayList<Article>)a.readQuery("from Article a where a.auteur = 'M22556'");
		System.out.println(chrs);
		for(Article article : articles) {
			System.out.println(article);
		}
	}

	static void q6() {
		a.remove(a.readQuery("from Article a where a.departement = 'Mathematiques'"));
	}

	@SuppressWarnings("unchecked")
	static void q7() {
		Query q = a.createQuery("from Article a where to_char(a.soumisLe,'YYYY/MM/DD') = '2007/05/16'");
		List<Article> arts = q.getResultList();
		for (Article art : arts) {
			c.remove(c.readQuery("from Chercheur c where c.matricule = '" + art.getAuteur() + "'"));
		}
	}

	static void q8() {
		d.updateQuery("update Departement set adresse = 'Quebec' where nom = 'Physique'");
	}

	static void q9() {
		List<Chercheur> chrs = c.readQuery("from Chercheur c where c.equipe = 'Integration'");
		for (Chercheur chr : chrs) {
			c.updateQuery("update Chercheur set position = 'postdoc' where matricule = '" + chr.getMatricule() + "'");
		}
	}

	static void q10() {
		Departement med = new Departement();
		med.setAdresse("Gaspesie");
		med.setDateCreation(new Date(1514782800000L));
		med.setNom("Medecine");
		med.setTelephone("555-555-5555");
		d.insertQuery(med);
	}

	static void q11() {
		Equipe eq = new Equipe();
		eq.setDateCreation(new Date(0));
		eq.setDep("Medecine");
		eq.setNbrProjets(42);
		eq.setNom("Pediatre");
		eq.setResponsable("Joe Bloe");
		e.insertQuery(eq);
	}

	public static void main(String[] args) {
		d.setUp();
		c.setUp();
		e.setUp();
		a.setUp();
		
		System.out.println("\nQuestion 1");
		q1();
		System.out.println("\nQuestion 2");
		q2();
		System.out.println("\nQuestion 3");
		q3();
		System.out.println("\nQuestion 4");
		q4();
		System.out.println("\nQuestion 5");
		q5();
		System.out.println("\nQuestion 6");
		q6();
		System.out.println("\nQuestion 7");
		q7();
		System.out.println("\nQuestion 8");
		q8();
		System.out.println("\nQuestion 9");
		q9();
		System.out.println("\nQuestion 10");
		q10();
		System.out.println("\nQuestion 11");
		q11();
		
		d.close();
		a.close();
		e.close();
		c.close();
	}
}
