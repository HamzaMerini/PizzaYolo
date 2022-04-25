package pizzayolo.entity;

public class Ingredient extends Food{


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
