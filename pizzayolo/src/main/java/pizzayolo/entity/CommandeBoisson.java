package pizzayolo.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "commande_boisson")
public class CommandeBoisson {
	@EmbeddedId
	@Column(name = "id_commande_boisson")
	@JsonView(JsonViews.CommandeWithItem.class)
	private CommandeBoissonKey idCB;

	@JsonView(JsonViews.CommandeWithItem.class)
	private double prix;
	
	@Column(name = "quantite_boisson")
	@JsonView(JsonViews.CommandeWithItem.class)
	private int quantiteBoisson;


	
	public CommandeBoisson() {
	}

	public CommandeBoisson(CommandeBoissonKey idCB, int quantiteBoisson) {
		this.idCB = idCB;
		this.quantiteBoisson = quantiteBoisson;
	}

	public CommandeBoissonKey getIdCB() {
		return idCB;
	}

	public void setIdCB(CommandeBoissonKey idCB) {
		this.idCB = idCB;
	}

	public int getQuantiteBoisson() {
		return quantiteBoisson;
	}

	public void setQuantiteBoisson(int quantiteBoisson) {
		this.quantiteBoisson = quantiteBoisson;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCB);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommandeBoisson other = (CommandeBoisson) obj;
		return Objects.equals(idCB, other.idCB);
	}

	@Override
	public String toString() {
		return "CommandeBoisson [idCB=" + idCB + ", quantiteBoisson=" + quantiteBoisson + "]";
	}

	
	
}
