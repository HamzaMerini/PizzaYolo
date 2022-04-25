package pizzayolo.entity;

public class Dessert {

	private int id;
	private String nom;
	private double prix;

	
	
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
