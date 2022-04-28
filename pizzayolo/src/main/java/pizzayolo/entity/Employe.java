package pizzayolo.entity;

import java.util.Date;
import java.util.Objects;

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

@Entity
@Table(name = "employe")
@SequenceGenerator(name = "seqEmploye", sequenceName = "seq_employe", initialValue = 10, allocationSize = 1)

public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEmploye")
	@Column(name = "matricule", nullable = false, unique = true)
	private Long matricule;
	@Column(name = "nom", nullable = false, length = 200)
	private String nom;
	@Column(name = "prenom", nullable = false, length = 200)
	private String prenom;
	@Column(name = "adresse", length = 200)
	private String adresse;
	@Column(name = "dateEmbauche", length = 200)
	private Date dateEmbauche;
	@Column(name = "salaire", nullable = false, length = 200)
	private double salaire;
	@Enumerated(EnumType.STRING)
	@Column(name = "job", nullable = false, length = 10)
	private Job job;

	@OneToOne
	@JoinColumn(name = "emp_user", foreignKey = @ForeignKey(name = "EMPLOYE_USER_FK"))
	private Utilisateur utilisateur;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "creneau", joinColumns = @JoinColumn(name = "employe_id", foreignKey = @ForeignKey(name = "CRENEAU_EMPLOYE_ID_FK")), inverseJoinColumns = @JoinColumn(name = "creneau_id", foreignKey = @ForeignKey(name = "CRENEAU_CRENEAU_ID_FK")))
	private Creneau creneaux;

	public Employe() {

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
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	public Creneau getCreneau() {
		return creneaux;
	}

	public void setCreneau(Creneau creneaux) {
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
