package pizzayolo.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Commande {
	
	protected int numTicket;
	protected List<Pizza> pizzas = new ArrayList();
	protected List<Dessert> desserts = new ArrayList();
	protected List<Boisson> boissons = new ArrayList();
	protected double PrixTotal; 
	

public double calculTotalPizzas(){
	double TotalPizzas=0 ;
	for (Pizza p : pizzas){
		TotalPizzas = TotalPizzas+ p.getPrix();
	}
return TotalPizzas;
}


public double calculTotalBoissons(){
	double TotalBoissons=0 ;
	for (Boisson b : boissons){
		TotalBoissons = TotalBoissons+ b.getPrix();
	}
return TotalBoissons;
}


public double calculTotalDesserts(){
	double TotalDesserts=0 ;
	for (Dessert d : desserts){
		TotalDesserts = TotalDesserts+ d.getPrix();
	}
return TotalDesserts;
}

public double calculTotal(){
	PrixTotal=calculTotalPizzas()+calculTotalBoissons()+calculTotalDesserts();
	return PrixTotal;
}

public void afficherTicketTotal(){
	System.out.println("----Pizza Yolo vous remercie----");
	
	
	if (pizzas.isEmpty()){
		System.out.println("-------------------");
		System.out.println("Aucune pizza command�e");
	}
	else {
		System.out.println("-------------------");
		System.out.println("Vos pizzas : ");
		for (Pizza p : pizzas){
			System.out.println(p.getRecette().getNom()+ " Prix : "+p.getPrix());
		}
	System.out.println("Total pizza : "+ calculTotalPizzas());
	}

	
		if (boissons.isEmpty()){
		System.out.println("-------------------");
		System.out.println("Aucune boisson command�e");
	}
	else {
		System.out.println("-------------------");
		System.out.println("Vos boissons : ");
		for (Boisson b : boissons){
			System.out.println(b.getNom()+ " Prix : "+b.getPrix());
		}
	System.out.println("Total boisson : "+ calculTotalBoissons());
	}
	


		if (desserts.isEmpty()){
		System.out.println("-------------------");
		System.out.println("Aucun dessert command�e");
	}
	else {
		System.out.println("-------------------");
		System.out.println("Vos desserts : ");
		for (Dessert d : desserts){
			System.out.println(d.getNom()+ " Prix : "+d.getPrix());
		}
	System.out.println("Total desserts : "+ calculTotalDesserts());
	
	}
	System.out.println("Total ticket : "+calculTotal()+" �." );
	System.out.println("A Bientot ! ");
	
	}
	



	
	
	

}


