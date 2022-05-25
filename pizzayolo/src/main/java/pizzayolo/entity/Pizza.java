package pizzayolo.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "pizza")
@SequenceGenerator(name = "seqPizza", sequenceName = "seq_pizza", initialValue = 1, allocationSize = 1)

public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPizza")
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "recette", foreignKey = @ForeignKey(name = "PIZZA_RECETTE_ID_FK"))
	@JsonView(JsonViews.CommandeWithItem.class)
	private Recette recette;

	@ManyToOne
	@JoinColumn(name = "numticket_id", foreignKey = @ForeignKey(name = "PIZZA_NUMTICKET_ID_FK"))
	private Commande commandePizza;
	
	@Column(name = "prix")
	@JsonView(JsonViews.CommandeWithItem.class)
	private double prix;

	@Enumerated(EnumType.STRING)
	@Column(name = "taille_pizza")
	@JsonView(JsonViews.CommandeWithItem.class)	
	private Taille taille;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type_pate")
	@JsonView(JsonViews.CommandeWithItem.class)	
	private TypePate pate;

	public Pizza() {
	}

	public Pizza(Recette recette, Taille taille, TypePate pate) {

		this.recette = recette;
		this.taille = taille;
		this.pate = pate;

		if (taille == Taille.Medium) {
			this.prix = recette.getPrixM();
		} else if (taille == Taille.Large) {
			this.prix = recette.getPrixL();
		} else {
			this.prix = recette.getPrixXL();
		}

		if (pate == TypePate.MozzaCrust) {
			this.prix = this.prix + pate.getPrix();
		} else if (pate == TypePate.Pan) {
			this.prix = this.prix + pate.getPrix();
		} else {
			this.prix = this.prix + pate.getPrix();
		}

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Commande getCommandePizza() {
		return commandePizza;
	}

	public void setCommandePizza(Commande commandePizza) {
		this.commandePizza = commandePizza;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Recette getRecette() {
		return recette;
	}

	public void setRecette(Recette recette) {
		this.recette = recette;
	}

	public Taille getTaille() {
		return taille;
	}

	public void setTaille(Taille taille) {
		this.taille = taille;
	}

	public TypePate getPate() {
		return pate;
	}

	public void setPate(TypePate pate) {
		this.pate = pate;
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
		Pizza other = (Pizza) obj;
		return Objects.equals(id, other.id);
	}

}
