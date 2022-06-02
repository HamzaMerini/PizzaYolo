package pizzayolo.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("L")
public class Livraison extends Commande {

	@Column(name = "heure_souhaite")
	@JsonView(JsonViews.CommandeWithItem.class)
	private String heureSouhaite;

	public Livraison() {
	}

	public String getHeureSouhaite() {
		return heureSouhaite;
	}

	public void setHeureSouhaite(String heureSouhaite) {
		this.heureSouhaite = heureSouhaite;
	}
}