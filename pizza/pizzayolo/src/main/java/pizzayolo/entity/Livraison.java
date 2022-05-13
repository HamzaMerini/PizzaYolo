package pizzayolo.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@DiscriminatorValue("L")
public class Livraison extends Commande{

	
	@Column(name="heure_souhaite")
	private String heureSouhaite; 
	@Column(name="prixlivraison")
	private double prixLivraison;

	
	
	public String getHeureSouhaite() {
		return heureSouhaite;
	}



	public void setHeureSouhaite(String heureSouhaite) {
		this.heureSouhaite = heureSouhaite;
	}



	public double getPrixLivraison() {
		return prixLivraison;
	}



	public void setPrixLivraison(double prixLivraison) {
		this.prixLivraison = prixLivraison;
	}



	public Livraison() {
		
	}

}