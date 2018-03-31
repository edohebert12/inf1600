package Model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class Article {

	@Id
	@Column(name="auteur")
	private String auteur;
	@Column(name="coauteur")
	private String coauteur;
	@Column(name="soumisLe")
	private Timestamp soumisLe;
	@Column(name="departement")
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
	
	public String toString() {
		return auteur + "," + coauteur + "," + soumisLe.toString();
	}
}
