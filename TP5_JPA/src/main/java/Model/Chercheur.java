package Model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.criteria.Order;

@Entity
@Table(name="chercheur")
public class Chercheur {

	@Id
	@Column(name="matricule")
	private String matricule;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="position")
	private String position;
	
	@Column(name="equipe")
	private String equipe;
	
	@Column(name="salaire")
	private Integer salaire;
	
	
	public String getMatricule() {
		return this.matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPosition() {
		return this.position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getEquipe() {
		return this.equipe;
	}
	
	public void setEquipe(String e) {
		this.equipe = e;
	}
	
	public Integer getSalaire() {
		return this.salaire;
	}
	public void setSalaire(Integer salaire) {
		this.salaire = salaire;
	}
	
	public String toString() {
		if(salaire == null) {
			return matricule + "," + prenom + "," + nom + "," + position;
		} else {
			return matricule + "," + prenom + "," + nom + "," + position + "," + salaire.toString();
		}
	}
	
}
