package pizzayolo.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "dessert")
@SequenceGenerator(name = "seqDessert", sequenceName = "seq_dessert", initialValue = 1, allocationSize = 1)

public class Dessert {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqDessert")
	@Column(name = "id")
	private int id;
	@Column(name = "nom")
	@JsonView(JsonViews.Common.class)
	private String nom;
	@Column(name = "prix")
	@JsonView(JsonViews.Common.class)
	private double prix;

	public Dessert() {
	}

	public Dessert(String nom, double prix) {
		this.nom = nom;
		this.prix = prix;
	}

	public Dessert(int id, String nom, double prix) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
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
		Dessert other = (Dessert) obj;
		return id == other.id;
	}


}
