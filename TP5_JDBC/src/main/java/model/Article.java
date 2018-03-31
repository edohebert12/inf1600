package model;

import java.sql.Timestamp;

public class Article {

	private String auteur;
	private String coauteur;
	private Timestamp soumisLe;
	private String departement;
	
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
	
	public String getDepartement() {
		return this.departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
}
