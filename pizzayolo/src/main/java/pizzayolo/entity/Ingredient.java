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

import pizzayolo.entity.Recette;
@Entity
@Table (name="Ingredient")
@SequenceGenerator(name = "seqIngredient", sequenceName = "seq_ingredient", initialValue = 1, allocationSize = 1)
public class Ingredient{


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqIngredient")
	private Long id;
	@ManyToMany(mappedBy = "ingredients")
	private Set<Recette> recettes;
	
	@Enumerated(EnumType.STRING)
	private TypeFood typeFood;

	public Ingredient() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Recette> getRecettes() {
		return recettes;
	}

	public void setRecettes(Set<Recette> recettes) {
		this.recettes = recettes;
	}

	public TypeFood getTypeFood() {
		return typeFood;
	}

	public void setTypeFood(TypeFood typeFood) {
		this.typeFood = typeFood;
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

	public Ingredient(Long id, Set<Recette> recettes, TypeFood typeFood) {
		super();
		this.id = id;
		this.recettes = recettes;
		this.typeFood = typeFood;
	}
	
	
}
