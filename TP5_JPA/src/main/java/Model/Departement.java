package Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departement")
public class Departement {
	@Id
	@Column(name="nom")
	private String nom;
	@Column(name="adresse")
	private String adresse;
	@Column(name="telephone")
	private String telephone;
	@Column(name="dateCreation")
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
