package pizzayolo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="commande")
@SequenceGenerator(name = "seqCommande", sequenceName = "seq_commande", initialValue = 1, allocationSize = 1)
public abstract class Commande {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqCommande")
	protected Long id;
	protected int numTicket;
	protected List<Pizza> pizzas = new ArrayList();
	protected List<Dessert> desserts = new ArrayList();
	protected List<Boisson> boissons = new ArrayList();
	protected double PrixTotal;
	

public Commande() {
		super();
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
	Commande other = (Commande) obj;
	return Objects.equals(id, other.id);
}



public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public int getNumTicket() {
	return numTicket;
}



public void setNumTicket(int numTicket) {
	this.numTicket = numTicket;
}



public List<Pizza> getPizzas() {
	return pizzas;
}



public void setPizzas(List<Pizza> pizzas) {
	this.pizzas = pizzas;
}



public List<Dessert> getDesserts() {
	return desserts;
}



public void setDesserts(List<Dessert> desserts) {
	this.desserts = desserts;
}



public List<Boisson> getBoissons() {
	return boissons;
}



public void setBoissons(List<Boisson> boissons) {
	this.boissons = boissons;
}



public double getPrixTotal() {
	return PrixTotal;
}



public void setPrixTotal(double prixTotal) {
	PrixTotal = prixTotal;
}



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


