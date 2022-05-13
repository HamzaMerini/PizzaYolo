package pizzayolo.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@SequenceGenerator(name = "seqDessert", sequenceName = "seq_dessert", initialValue = 1, allocationSize = 1)
@Table(name="dessert")
public class Dessert {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqDessert")
	private int id;
	private String nom;
	private double prix;

	
	
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



	public Dessert() {
		super();
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
	public String toString() {
		return "Dessert [id=" + id + ", nom=" + nom + ", prix=" + prix + "]";
	}

}
