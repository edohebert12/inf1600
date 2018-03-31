package Model;

import java.sql.Date;

public class Equipe {
	
	private Date dateCreation;
	private String nom;
	private Departement departement;
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
	
	public Departement getDep() {
		return this.departement;
	}
	public void setDep(Departement departement) {
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
