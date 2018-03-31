package model;

import java.sql.Date;

public class Equipe {
	
	private Date dateCreation;
	private String nom;
	private String departement;
	private String responsable;
	private Integer nbrProjets;
	
	
	public Date getDateCreation() {
		return this.dateCreation;
	}
	public void setDateCreation(Date date) {
		this.dateCreation = date;
	}
	
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getDepartement() {
		return this.departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	
	public String getResponsable() {
		return this.responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
	public Integer getNbrProjets() {
		return this.nbrProjets;
	}
	public void setNbrProjets(Integer nbrProjets) {
		this.nbrProjets = nbrProjets;
	}
	
}
