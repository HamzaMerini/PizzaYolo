package pizzayolo.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
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
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "commande")
@SequenceGenerator(name = "seqCommande", sequenceName = "seq_commande", initialValue = 1, allocationSize = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_commande", discriminatorType = DiscriminatorType.STRING, length = 5)

public abstract class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCommande")
	@Column(name = "num_ticket")
	protected Long numTicket;

	@OneToMany(mappedBy = "idCB.commandeBoisson")
	Set<CommandeBoisson> boissons;

	@OneToMany(mappedBy = "idCD.commandeDessert")
	Set<CommandeDessert> desserts;

	@OneToMany(mappedBy = "commandePizza")
	Set<Pizza> pizzas;

	@ManyToOne
	@JoinColumn(name = "id_client", foreignKey = @ForeignKey(name = "COMMANDE_ID_CLIENT_FK"))
	protected Utilisateur clientTicket;

	@Column(name = "date_ticket")
	protected LocalDate dateTicket;

	@Column(name = "prix_total")
	protected double prixTotal;

	public Commande() {
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
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}


	@Override
	public int hashCode() {
		return Objects.hash(numTicket);
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
		return Objects.equals(numTicket, other.numTicket);
	}

	


}
