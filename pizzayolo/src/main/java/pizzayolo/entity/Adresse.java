package pizzayolo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class Adresse {
	
	@Column(name="numero")
	@JsonView(JsonViews.UtilisateurWithAdresse.class)
	private String numVoie;
	@Column(name="rue")
	@JsonView(JsonViews.UtilisateurWithAdresse.class)
	private String nomVoie;
	@Column(name="complement")
	@JsonView(JsonViews.UtilisateurWithAdresse.class)
	private String complement;
	@Column(name="code_postale")
	@JsonView(JsonViews.UtilisateurWithAdresse.class)
	private String cp;
	@Column(name="ville")
	@JsonView(JsonViews.UtilisateurWithAdresse.class)
	private String ville;

	public Adresse() {
	}

	public Adresse(String numVoie, String nomVoie, String complement, String cp, String ville) {
		this.numVoie = numVoie;
		this.nomVoie = nomVoie;
		this.complement = complement;
		this.cp = cp;
		this.ville = ville;
	}

	public String getNumVoie() {
		return numVoie;
	}

	public void setNumVoie(String numVoie) {
		this.numVoie = numVoie;
	}

	public String getNomVoie() {
		return nomVoie;
	}

	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
