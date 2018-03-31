package Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="equipe")
public class Equipe {

	@Column(name="dateCreation")
	private Date dateCreation;
	@Id
	@Column(name="nom")
	private String nom;
	@Column(name="departement")
	private String departement;
	@Column(name="responsable")
	private String responsable;
	@Column(name="nbrProjets")
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
	
	public String getDep() {
		return this.departement;
	}
	
	public void setDep(String departement) {
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
