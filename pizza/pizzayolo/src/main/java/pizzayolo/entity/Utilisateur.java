package pizzayolo.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
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
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
@SequenceGenerator(name = "seqUtilisateur", sequenceName = "seq_utilisateur", initialValue = 1, allocationSize = 1)

public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUtilisateur")
	@Column(name = "id")
	private Long id;
	@Column(name = "mail")
	private String mail;
	@Column(name = "mdp")
	private String mdp;
	@Column(name = "nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Embedded
	// GERER LE NOM DES COLONNES DANS ADRESSES ?
	private Adresse adresse;
	@Column(name = "type")
	private String type; // client employe ou responsable

	@OneToMany(mappedBy = "clientTicket")
	Set<Commande> historiqueCommande;

	@OneToOne(mappedBy = "utilisateur")// PAS TOUJOURS VRAI DANS LE SENS OU UN UTILSATEUR NEST PAS FORCEMENT UN EMPLYE
	private Employe employe;

	public Utilisateur() {

	}

	public Utilisateur(Long id, String mail, String mdp, String prenom,String nom, Adresse adresse, String type) {
		this.id = id;
		this.mail = mail;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom=prenom;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
