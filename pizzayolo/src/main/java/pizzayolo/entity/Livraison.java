package pizzayolo.entity;

public class Livraison extends Commande{

	private String heureSouhaite; 
	private double prixLivraison;
	
public double calculTotal(){
	PrixTotal=calculTotalPizzas()+calculTotalBoissons()+calculTotalDesserts()+prixLivraison;
	return PrixTotal;
}

}