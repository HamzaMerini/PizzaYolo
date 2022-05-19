package pizzayolo.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("L")
public class Livraison extends Commande {

	@Column(name = "heure_souhaite")
	private String heureSouhaite;
	@Column(name = "prix_livraison")
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

	public Livraison(Set<CommandeBoisson> boissons, Set<CommandeDessert> desserts, Set<Pizza> pizzas,
			Utilisateur clientTicket, LocalDate dateTicket, double prixTotal, String heureSouhaite,
			double prixLivraison) {
		super(boissons, desserts, pizzas, clientTicket, dateTicket, prixTotal);
		this.heureSouhaite = heureSouhaite;
		this.prixLivraison = prixLivraison;
	}


	
	
	
	
}