package pizzayolo.entity;

public class Utilisateur {
	
		private Integer id;
		private String mail;
		private String mdp;
		private String nom;
		private Adresse adresse;
		private String type; // client employe ou responsable 
		
	public Utilisateur() {
		
		
	}

	public Utilisateur(Integer id, String mail, String mdp, String nom, Adresse adresse, String type) {
		
		this.id = id;
		this.mail = mail;
		this.mdp = mdp;
		this.nom = nom;
		this.adresse = adresse;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", mail=" + mail + ", mdp=" + mdp + ", nom=" + nom + ", adresse=" + adresse
				+ ", type=" + type + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
