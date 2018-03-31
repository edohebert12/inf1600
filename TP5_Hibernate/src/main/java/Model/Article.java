package Model;

import java.sql.Timestamp;

public class Article {

	private String auteur;
	private String coauteur;
	private Timestamp soumisLe;
	private Departement departement;
	
	public String getAuteur() {
		return this.auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	public String getCoauteur() {
		return this.coauteur;
	}
	public void setCoauteur(String coauteur) {
		this.coauteur = coauteur;
	}
	
	public Timestamp getSoumisLe() {
		return this.soumisLe;
	}
	public void setSoumisLe(Timestamp soumisLe) {
		this.soumisLe = soumisLe;
	}
	
	public Departement getDepartement() {
		return this.departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	public String toString() {
		return auteur + "," + coauteur + "," + soumisLe.toString();
	}
}
