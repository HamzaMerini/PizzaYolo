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
@Table(name = "boisson")
@SequenceGenerator(name = "seqBoisson", sequenceName = "seq_commande", initialValue = 1, allocationSize = 1)

public class Boisson {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqBoisson")
	@Column(name = "id")
	@JsonView(JsonViews.Common.class)
	private Integer id;
	
	@JsonView({JsonViews.Common.class,JsonViews.CommandeWithItem.class})
	@Column(name = "nom")
	private String nom;
	
	@JsonView(JsonViews.Common.class)
	@Column(name = "prix")
	private double prix;

	public Boisson() {
	}

	public Boisson(String nom, double prix) {
		this.nom = nom;
		this.prix = prix;
	}

	public Boisson(Integer id, String nom, double prix) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		Boisson other = (Boisson) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
}
