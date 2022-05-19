package pizzayolo.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class CommandeBoissonKey implements Serializable {

	@ManyToOne
	@JoinColumn(name = "boisson_id", foreignKey = @ForeignKey(name = "boisson_commande_boisson_id_fk"))
	private Boisson boisson;

	@ManyToOne
	@JoinColumn(name = "commande_id", foreignKey = @ForeignKey(name = "boisson_commande_commande_id_fk"))
	private Commande commandeBoisson;

	public CommandeBoissonKey() {
		super();
	}

	public CommandeBoissonKey(Boisson boisson, Commande commande) {
		this.boisson = boisson;
		this.commandeBoisson = commande;
	}

	public Boisson getBoisson() {
		return boisson;
	}

	public void setboisson(Boisson boisson) {
		this.boisson = boisson;
	}

	public Commande getCommandeBoisson() {
		return commandeBoisson;
	}

	public void setCommandeBoisson(Commande commandeBoisson) {
		this.commandeBoisson = commandeBoisson;
	}

	public void setBoisson(Boisson boisson) {
		this.boisson = boisson;
	}


}