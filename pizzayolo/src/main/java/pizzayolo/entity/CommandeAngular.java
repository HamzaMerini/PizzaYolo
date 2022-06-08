package pizzayolo.entity;


import java.util.Set;

public class CommandeAngular {
	Set<BoissonAngular> boissons;
	Set<DessertAngular> desserts;
	Set<Pizza> pizzas;
	Long prixTotal;
	String typeCommande;
	String heureSouhaite;
	String place;
	Utilisateur clientTicket;
	
	
	public CommandeAngular() {
		
	}

	public CommandeAngular(Set<BoissonAngular> boissons, Set<DessertAngular> desserts, Set<Pizza> pizzas,
			Long prixTotal, String typeCommande, String heureSouhaite, String place, Utilisateur clientTicket) {
		super();
		this.boissons = boissons;
		this.desserts = desserts;
		this.pizzas = pizzas;
		this.prixTotal = prixTotal;
		this.typeCommande = typeCommande;
		this.heureSouhaite = heureSouhaite;
		this.place = place;
		this.clientTicket = clientTicket;
	}




	public Utilisateur getClientTicket() {
		return clientTicket;
	}
	public void setClientTicket(Utilisateur clientTicket) {
		this.clientTicket = clientTicket;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Set<BoissonAngular> getBoissons() {
		return boissons;
	}
	public void setBoissons(Set<BoissonAngular> boissons) {
		this.boissons = boissons;
	}
	public Set<DessertAngular> getDesserts() {
		return desserts;
	}
	public void setDesserts(Set<DessertAngular> desserts) {
		this.desserts = desserts;
	}
	public Set<Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(Set<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	public Long getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(Long prixTotal) {
		this.prixTotal = prixTotal;
	}
	public String getTypeCommande() {
		return typeCommande;
	}
	public void setTypeCommande(String typeCommande) {
		this.typeCommande = typeCommande;
	}
	public String getheureSouhaite() {
		return heureSouhaite;
	}
	public void setheureSouhaite(String heureSouhaite) {
		this.heureSouhaite = heureSouhaite;
	}

	
	
}
