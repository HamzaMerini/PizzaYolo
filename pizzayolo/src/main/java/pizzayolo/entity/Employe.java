package pizzayolo.entity;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "employe")
@SequenceGenerator(name = "seqEmploye", sequenceName = "seq_employe", initialValue = 10, allocationSize = 1)

public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEmploye")
	@Column(name = "matricule", nullable = false)
	@JsonView(JsonViews.Common.class)
	private Long matricule;

	@Column(name = "nom", nullable = false)
	@JsonView(JsonViews.Common.class)
	private String nom;

	@JsonView(JsonViews.Common.class)
	@Column(name = "prenom", nullable = false)
	private String prenom;

	@Column(name = "adresse")
	private String adresse;

	@JsonView(JsonViews.Common.class)
	@Column(name = "date_embauche")
	private Date dateEmbauche;

	@JsonView(JsonViews.Common.class)
	@Column(name = "salaire")
	private double salaire;

	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.STRING)
	@Column(name = "job")
	private Job job;

	@OneToOne
	@JoinColumn(name = "emp_user", foreignKey = @ForeignKey(name = "EMPLOYE_USER_FK"))
	private Utilisateur utilisateur;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "creneau_employe", joinColumns = @JoinColumn(name = "employe_id", foreignKey = @ForeignKey(name = "CRENEAU_EMPLOYE_ID_FK")), inverseJoinColumns = @JoinColumn(name = "creneau_id", foreignKey = @ForeignKey(name = "CRENEAU_CRENEAU_ID_FK")))
	private Set<Creneau> creneaux;

	public Employe() {

	}

	public Employe(String nom, String prenom) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom.substring(0, 1).toUpperCase() + prenom.substring(1, prenom.length()).toLowerCase();
	}

	public Long getMatricule() {
		return matricule;
	}

	public void setMatricule(Long matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom.toUpperCase();
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom.substring(0, 1).toUpperCase() + prenom.substring(1, prenom.length()).toLowerCase();
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Set<Creneau> getCreneaux() {
		return creneaux;
	}

	public void setCreneaux(Set<Creneau> creneaux) {
		this.creneaux = creneaux;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricule);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employe other = (Employe) obj;
		return Objects.equals(matricule, other.matricule);
	}

}
