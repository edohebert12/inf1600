package Model;

public class Chercheur {

	private String matricule;
	private String prenom;
	private String nom;
	private String position;
	private Integer salaire;
	private Equipe equipe;
	
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
	
	public Integer getSalaire() {
		return this.salaire;
	}
	public void setSalaire(Integer salaire) {
		this.salaire = salaire;
	}
	
	public Equipe getEquipe() {
		return this.equipe;
	}
	public void setEquipe(Equipe value) {
		this.equipe = value;
	}
	
	public String toString() {
		if(salaire == null) {
			return matricule + "," + prenom + "," + nom + "," + position;
		} else {
			return matricule + "," + prenom + "," + nom + "," + position + "," + salaire.toString();
		}
	}
}
