package pizzayolo.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import pizzayolo.entity.Recette;
@Entity
@Table (name="Ingredient")
public class Ingredient extends Food{


	@ManyToMany(mappedBy = "ingredients")
	private Set<Recette> recettes;


	   


	public Ingredient(Integer id,String libelle,double prixSupM) {
		super(id,libelle,prixSupM);
	}

	
	public Ingredient(String libelle,double prixSupM) {
		super(libelle,prixSupM);
	}

	public Ingredient(String libelle) {
		super(libelle);
	}

}
