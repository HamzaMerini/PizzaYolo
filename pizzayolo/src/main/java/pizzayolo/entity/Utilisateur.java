package pizzayolo.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqUtilisateur",sequenceName = "seq_utilisateur", initialValue = 1, allocationSize = 1)
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="seqUtilisateur" )
		private Long id;
		
		private String mail;
		private String mdp;
		private String nom;
		@Embedded
		private Adresse adresse;
		private String type; // client employe ou responsable 
		
		@OneToMany(mappedBy = "clientTicket")
		Set<Commande> historiqueCommande;
		
	
		@OneToOne(mappedBy = "utilisateur")
	    private Employe employe;
		
	public Utilisateur() {
		
		
	}

	public Utilisateur(Long id, String mail, String mdp, String nom, Adresse adresse, String type) {
		
		this.id = id;
		this.mail = mail;
		this.mdp = mdp;
		this.nom = nom;
		this.adresse = adresse;
		this.type = type;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Set<Commande> getHistoriqueCommande() {
		return historiqueCommande;
	}

	public void setHistoriqueCommande(Set<Commande> historiqueCommande) {
		this.historiqueCommande = historiqueCommande;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(id, other.id);
	}
	

}
