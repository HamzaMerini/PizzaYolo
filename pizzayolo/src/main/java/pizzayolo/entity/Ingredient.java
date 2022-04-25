package pizzayolo.entity;

public class Ingredient {
	
	private Integer id;
	private String libelle;
	private double prixSupM;
	private double prixSupL;
	private double prixSupXL;
	
	public Ingredient(String libelle) {
		
		this.libelle = libelle;
		this.prixSupM = 0;
		this.prixSupL = 0;
		this.prixSupXL = 0;
	}
	
	
	public Ingredient(String libelle, double prixSupM) {
		
		this.libelle = libelle;
		this.prixSupM = prixSupM;
		this.prixSupL = prixSupM+0.5;
		this.prixSupXL = prixSupL+0.5;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
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
	
	
	@Override
	public String toString() {
		
		return ""+getLibelle()+"";
		
//		return "Ingredient [id=" + id + ", libelle=" + libelle + ", prixSupM=" + prixSupM + ", prixSupL=" + prixSupL
//				+ ", prixSupXL=" + prixSupXL + "]";
	}

	
	
///AJOUTER LES BASES !!!!


	













}


