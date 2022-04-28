package pizzayolo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("L")
public class Livraison extends Commande{

	private String heureSouhaite; 
	private double prixLivraison;

	
	
	public Livraison() {
		
	}



	public double calculTotal(){
		PrixTotal=calculTotalPizzas()+calculTotalBoissons()+calculTotalDesserts()+prixLivraison;
		return PrixTotal;
	}

}