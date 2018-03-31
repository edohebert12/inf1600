package Model;

import java.sql.Date;

public class Departement {

	private String nom;
	private String adresse;
	private String telephone;
	private Date dateCreation;
	
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return this.adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(String tel) {
		this.telephone = tel;
	}
	public Date getDateCreation() {
		return this.dateCreation;
	}
	public void setDateCreation(Date date) {
		this.dateCreation = date;
	}
	
	public String toString() {
		return nom + "," + adresse + "," + telephone + "," + dateCreation.toString();
	}
}
