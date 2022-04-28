package pizzayolo.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
@Entity
@SequenceGenerator(name="seqCommande",sequenceName = "seq_commande", initialValue = 1, allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_commande", discriminatorType = DiscriminatorType.STRING,length = 1)
public abstract class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="seqCommande" )
	protected Long numTicket;
	//rajouter le @OneToMany(mappedby="") mapped by en fonction du nom des clef primaire donné par joe pour Dessert
	@OneToMany(mappedBy = "idCB.commande")
	Set<CommandeBoisson> boissons;
	
	//rajouter le @OneToMany(mappedby="") mapped by en fonction du nom des clef primaire donné par joe pour Boisson
	@OneToMany(mappedBy = "idCD.commande")
	Set<CommandeDessert> desserts;
	
	// rejouter le @OneToMany(mappedby="") mapped by en fonction du nom de la clef etrangere donné à la commande dans la table pizza par Khadidja
	@OneToMany(mappedBy="commande")
	Set<Pizza> pizzas;
	
	

//	protected List<Dessert> desserts = new ArrayList();devrait devenir inutile car les boisson sont géré par le couple CommandeDessert
//	protected List<Boisson> boissons = new ArrayList();  //devrait devenir inutile car les boisson sont géré par le couple CommandeBoisson
	
	@ManyToOne
	@JoinColumn(name = "id_client", foreignKey = @ForeignKey(name = "COMMANDE_ID_CLIENT_FK"))
	protected Utilisateur clientTicket;
	
	protected LocalDate dateTicket;
	
	protected double PrixTotal; 

public Commande() { 
		super();
	}

//A refaire : 
//public double calculTotalPizzas(){
//	double TotalPizzas=0 ;
//	for (Pizza p : pizzas){
//		TotalPizzas = TotalPizzas+ p.getPrix();
//	}
//return TotalPizzas;
//}
//
//
//public double calculTotalBoissons(){
//	double TotalBoissons=0 ;
//	for (Boisson b : boissons){
//		TotalBoissons = TotalBoissons+ b.getPrix();
//	}
//return TotalBoissons;
//}
//
//
//public double calculTotalDesserts(){
//	double TotalDesserts=0 ;
//	for (Dessert d : desserts){
//		TotalDesserts = TotalDesserts+ d.getPrix();
//	}
//return TotalDesserts;
//}
//
//public double calculTotal(){
//	PrixTotal=calculTotalPizzas()+calculTotalBoissons()+calculTotalDesserts();
//	return PrixTotal;
//}
//
//public void afficherTicketTotal(){
//	System.out.println("----Pizza Yolo vous remercie----");
//	
//	
//	if (pizzas.isEmpty()){
//		System.out.println("-------------------");
//		System.out.println("Aucune pizza command�e");
//	}
//	else {
//		System.out.println("-------------------");
//		System.out.println("Vos pizzas : ");
//		for (Pizza p : pizzas){
//			System.out.println(p.getRecette().getNom()+ " Prix : "+p.getPrix());
//		}
//	System.out.println("Total pizza : "+ calculTotalPizzas());
//	}
//
//	
//		if (boissons.isEmpty()){
//		System.out.println("-------------------");
//		System.out.println("Aucune boisson command�e");
//	}
//	else {
//		System.out.println("-------------------");
//		System.out.println("Vos boissons : ");
//		for (Boisson b : boissons){
//			System.out.println(b.getNom()+ " Prix : "+b.getPrix());
//		}
//	System.out.println("Total boisson : "+ calculTotalBoissons());
//	}
//	
//
//
//		if (desserts.isEmpty()){
//		System.out.println("-------------------");
//		System.out.println("Aucun dessert command�e");
//	}
//	else {
//		System.out.println("-------------------");
//		System.out.println("Vos desserts : ");
//		for (Dessert d : desserts){
//			System.out.println(d.getNom()+ " Prix : "+d.getPrix());
//		}
//	System.out.println("Total desserts : "+ calculTotalDesserts());
//	
//	}
//	System.out.println("Total ticket : "+calculTotal()+" �." );
//	System.out.println("A Bientot ! ");
//	
//	}


@Override
public int hashCode() {
	return Objects.hash(numTicket);
}


public Long getNumTicket() {
	return numTicket;
}

public void setNumTicket(Long numTicket) {
	this.numTicket = numTicket;
}

public Set<CommandeBoisson> getBoissons() {
	return boissons;
}

public void setBoissons(Set<CommandeBoisson> boissons) {
	this.boissons = boissons;
}

public Set<CommandeDessert> getDesserts() {
	return desserts;
}

public void setDesserts(Set<CommandeDessert> desserts) {
	this.desserts = desserts;
}

public Set<Pizza> getPizzas() {
	return pizzas;
}

public void setPizzas(Set<Pizza> pizzas) {
	this.pizzas = pizzas;
}

public Utilisateur getClientTicket() {
	return clientTicket;
}

public void setClientTicket(Utilisateur clientTicket) {
	this.clientTicket = clientTicket;
}

public LocalDate getDateTicket() {
	return dateTicket;
}

public void setDateTicket(LocalDate dateTicket) {
	this.dateTicket = dateTicket;
}

public double getPrixTotal() {
	return PrixTotal;
}

public void setPrixTotal(double prixTotal) {
	PrixTotal = prixTotal;
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
	return numTicket == other.numTicket;
}
	



	
	
	

}


