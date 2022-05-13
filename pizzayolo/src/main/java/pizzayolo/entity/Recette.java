package pizzayolo.entity;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "recette")
@SequenceGenerator(name = "seqRecette", sequenceName = "seq_recette", initialValue = 1, allocationSize = 1)
public class Recette { 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRecette")
	private Long id;
	private String nom;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "lien_recette_ingredients", 
			   joinColumns = @JoinColumn(name = "ingredient_id", foreignKey = @ForeignKey(name = "INGREDIENT_RECETTE_ID_FK")), 
			   inverseJoinColumns = @JoinColumn(name = "recette_id", foreignKey = @ForeignKey(name = "INGREDIENT_INGREDIENT_ID_FK")))
	private Set<Ingredient> listeIngre;

//	@OneToMany(mappedBy = "recette")
//	private Pizza pizza;

	private double prixM;
	private double prixL;
	private double prixXL;
	//private List<Food> listeIngre;



	public Recette(Long id,String nom, double prixM) {
		this.id=id;
		this.nom = nom;
		this.prixM = prixM;
		this.prixL = prixM+3;
		this.prixXL = prixL+3;
	}


	public Recette() {
		super();
	}


	public Recette(String nom, double prixM) {

		this.nom = nom;
		this.prixM = prixM;
		this.prixL = prixM+3;
		this.prixXL = prixL+3;
	}


	public Recette(String nom, double prixM,Set<Ingredient> listeIngre) {

		this.nom = nom;
		this.prixM = prixM;
		this.prixL = prixM+3;
		this.prixXL = prixL+3;
		this.listeIngre = listeIngre;
	}

	public Recette(Set<Ingredient> listeIngre) {

		this.nom = "Compos�e";
		this.prixM = 10;
		this.prixL = prixM+3;
		this.prixXL = prixL+3;
		//this.listeIngre = listeIngre;
	}


//	public Set<Ingredient> getIngredients() {
//		return ingredients;
//	}
//
//
//	public void setIngredients(Set<Ingredient> ingredients) {
//		this.ingredients = ingredients;
//	}


//	public Pizza getPizza() {
//		return pizza;
//	}
//
//
//	public void setPizza(Pizza pizza) {
//		this.pizza = pizza;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrixM() {
		return prixM;
	}

	public void setPrixM(double prixM) {
		this.prixM = prixM;
	}

	public double getPrixL() {
		return prixL;
	}

	public void setPrixL(double prixL) {
		this.prixL = prixL;
	}

	public double getPrixXL() {
		return prixXL;
	}

	public void setPrixXL(double prixXL) {
		this.prixXL = prixXL;
	}




	//	public Set<Food> getListeIngre() {
	//		return listeIngre;
	//	}
	//
	//	public void setListeIngre(Set<Food> listeIngre) {
	//		this.listeIngre = listeIngre;
	//	}


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
		Recette other = (Recette) obj;
		return Objects.equals(id, other.id);
	}








}

