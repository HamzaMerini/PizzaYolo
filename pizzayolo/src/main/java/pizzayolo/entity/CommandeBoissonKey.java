package pizzayolo.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class CommandeBoissonKey implements Serializable {

	@ManyToOne
	@JoinColumn(name = "boisson_id", foreignKey = @ForeignKey(name = "boisson_commande_boisson_id_fk"))
	@JsonView(JsonViews.CommandeWithItem.class)
	private Boisson boisson;

	@ManyToOne
	@JoinColumn(name = "commande_id", foreignKey = @ForeignKey(name = "boisson_commande_commande_id_fk"))
	private Commande commandeBoisson;

	public CommandeBoissonKey() {
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

	@Override
	public int hashCode() {
		return Objects.hash(boisson, commandeBoisson);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommandeBoissonKey other = (CommandeBoissonKey) obj;
		return Objects.equals(boisson, other.boisson) && Objects.equals(commandeBoisson, other.commandeBoisson);
	}

}
