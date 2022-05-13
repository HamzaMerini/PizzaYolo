package pizzayolo.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Ingredient")
@SequenceGenerator(name = "seqIngredient", sequenceName = "seq_ingredient", initialValue = 1, allocationSize = 1)
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqIngredient")
	private Long id;
	private String libelle;
	private double prixSupM;
	private double prixSupL;
	private double prixSupXL;

	@ManyToMany(mappedBy = "listeIngre")
	private Set<Recette> recettes;

	@Enumerated(EnumType.STRING)
	private TypeIngredient typeIngredient;

	public Ingredient() {
	}

	public Ingredient(String libelle) {
		this.libelle = libelle;
//		this.prixSupM = 0;
//		this.prixSupL = 0;
//		this.prixSupXL = 0;
		this.typeIngredient = TypeIngredient.Base;
	}

	public Ingredient(String libelle, double prixSupM) {
		this.libelle = libelle;

		if (prixSupM != 0) {
			this.prixSupM = prixSupM;
			this.prixSupL = prixSupM + 0.5;
			this.prixSupXL = prixSupM + 1;
		}
		this.typeIngredient = TypeIngredient.Ingredient;
	}

//	public Ingredient(Long id, Set<Recette> recettes, TypeFood typeFood) {
//	super();
//	this.id = id;
//	this.recettes = recettes;
//	this.typeFood = typeFood;
//}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Set<Recette> getRecettes() {
//		return recettes;
//	}
//
//	public void setRecettes(Set<Recette> recettes) {
//		this.recettes = recettes;
//	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrixSupM() {
		return prixSupM;
	}

	public void setPrixSupM(double prixSupM) {
		this.prixSupM = prixSupM;
	}

	public double getPrixSupL() {
		return prixSupL;
	}

	public void setPrixSupL(double prixSupL) {
		this.prixSupL = prixSupL;
	}

	public double getPrixSupXL() {
		return prixSupXL;
	}

	public void setPrixSupXL(double prixSupXL) {
		this.prixSupXL = prixSupXL;
	}

	public TypeIngredient getTypeIngredient() {
		return typeIngredient;
	}

	public void setTypeIngredient(TypeIngredient typeIngredient) {
		this.typeIngredient = typeIngredient;
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
		Ingredient other = (Ingredient) obj;
		return Objects.equals(id, other.id);
	}

}
