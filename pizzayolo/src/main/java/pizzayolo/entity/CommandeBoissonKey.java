package pizzayolo.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
@Embeddable
public class CommandeBoissonKey implements Serializable{

	@ManyToOne
	@JoinColumn(name = "boisson_id", foreignKey = @ForeignKey(name = "boisson_commande_boisson_id_fk"))
	private Boisson boisson;
	
	@ManyToOne
	@JoinColumn (name="commande_id",foreignKey=@ForeignKey (name = "boisson_commande_commande_id_fk") )
	private Commande commande;

	public CommandeBoissonKey() {
		super();
	}

	public CommandeBoissonKey(Boisson boisson, Commande commande) {
		super();
		this.boisson = boisson;
		this.commande = commande;
	}

	public Boisson getBoisson() {
		return boisson;
	}

	public void setboisson(Boisson boisson) {
		this.boisson = boisson;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Override
	public int hashCode() {
		return Objects.hash(boisson, commande);
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
		return Objects.equals(boisson, other.boisson) && Objects.equals(commande, other.commande);
	}
	
	
}
