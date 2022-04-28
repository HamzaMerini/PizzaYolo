package pizzayolo.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Embeddable
public class CommandeDessertKey implements Serializable{
	@ManyToOne
	@JoinColumn(name = "dessert_id", foreignKey = @ForeignKey(name = "dessert_commande_dessert_id_fk"))
	private Dessert dessert;
	
	@ManyToOne
	@JoinColumn (name="commande_id",foreignKey=@ForeignKey (name = "dessert_commande_commande_id_fk") )
	private Commande commande;

	public CommandeDessertKey() {
		super();
	}

	public CommandeDessertKey(Dessert dessert, Commande commande) {
		super();
		this.dessert = dessert;
		this.commande = commande;
	}

	public Dessert getDessert() {
		return dessert;
	}

	public void setDessert(Dessert dessert) {
		this.dessert = dessert;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commande, dessert);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommandeDessertKey other = (CommandeDessertKey) obj;
		return Objects.equals(commande, other.commande) && Objects.equals(dessert, other.dessert);
	}
	
	

	

}
