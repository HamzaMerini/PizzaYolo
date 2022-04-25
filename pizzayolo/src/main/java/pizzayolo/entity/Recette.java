package pizzayolo.entity;

import java.util.List;

public class Recette {
	
	private Integer id;
	private String nom;
	private double prixM;
	private double prixL;
	private double prixXL;
	private List<Ingredient> listeIngre;

	public Recette(String nom, double prixM,List<Ingredient> listeIngre) {
		
		this.nom = nom;
		this.prixM = prixM;
		this.prixL = prixM+3;
		this.prixXL = prixL+3;
		this.listeIngre = listeIngre;
	}
	
	public Recette(double prixM,List<Ingredient> listeIngre) {
	
		this.nom = "Compos�e";
		this.prixM = prixM;
		this.prixL = prixM+3;
		this.prixXL = prixL+3;
		this.listeIngre = listeIngre;
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
	
	


	public List<Ingredient> getListeIngre() {
		return listeIngre;
	}

	public void setListeIngre(List<Ingredient> listeIngre) {
		this.listeIngre = listeIngre;
	}
	
	@Override
	public String toString() {	
		return ""+nom+" : "+getListeIngre();
		
//		return "Recette [id=" + id + ", nom=" + nom + ", prixM=" + prixM + ", prixL=" + prixL + ", prixXL=" + prixXL
//				+ ", listeIngre=" + listeIngre + "]";
	}
	
	
	
	
	
	
}
