package pizzayolo.entity;

import java.lang.annotation.Repeatable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "utilisateur")
@SequenceGenerator(name = "seqUtilisateur", sequenceName = "seq_utilisateur", initialValue = 1, allocationSize = 1)

public class Utilisateur implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUtilisateur")
	@Column(name = "id")
	@JsonView(JsonViews.Common.class)
	private Long id;
	
	@Column(name = "mail")
	@NotEmpty
	@JsonView({JsonViews.Common.class,JsonViews.CommandeWithItem.class})
	@Email
	private String mail;
	
	@Column(name = "mdp")
	@NotEmpty
	@ValidPassword
	private String mdp;
	
	@Column(name = "nom")
	@JsonView({JsonViews.Common.class,JsonViews.CommandeWithItem.class})
	private String nom;
	
	@Column(name="prenom")
	@JsonView(JsonViews.Common.class)
	private String prenom;
	
	@Embedded
	@JsonView(JsonViews.UtilisateurWithAdresse.class)
	private Adresse adresse;
	
	@Column(name = "type")
	@JsonView(JsonViews.Common.class)
	private String type; // client employe ou responsable

	@OneToMany(mappedBy = "clientTicket")
	Set<Commande> historiqueCommande;

	@OneToOne(mappedBy = "utilisateur")// PAS TOUJOURS VRAI DANS LE SENS OU UN UTILSATEUR NEST PAS FORCEMENT UN EMPLYE
	private Employe employe;

	public Utilisateur() {

	}

	public Utilisateur( String mail, String mdp, String prenom,String nom, Adresse adresse, String type) {
		
		this.mail = mail;
		this.mdp = mdp;
		this.nom = nom.toUpperCase();
		this.prenom=prenom.substring(0, 1).toUpperCase() + prenom.substring(1,prenom.length()).toLowerCase();
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
		this.nom = nom.toUpperCase();
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
		this.prenom = prenom.substring(0, 1).toUpperCase() + prenom.substring(1,prenom.length()).toLowerCase();
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_"+type));
	}

	@Override
	public String getPassword() {
		return mdp;
	}

	@Override
	public String getUsername() {
		return mail;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}