package pizzayolo.entity;

public class Boisson {
	
	private Integer id;
	private String nom;
    private double prix;

	

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


	
	public String toString() {
		return "Boisson [id=" + id + ", nom=" + nom + ", prix=" + prix + "]";
	}

	
	
}
