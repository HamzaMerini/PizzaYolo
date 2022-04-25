package pizzayolo.entity;

public class Pizza {

	private static int cpt=0;
	private Integer id;
	private double prix;
	private Recette recette;
	private Taille taille;
	private TypePate pate;


	public Pizza(Recette recette,Taille taille,TypePate pate) {
		cpt++;
		this.id = cpt;
		this.recette = recette;
		this.taille = taille;
		this.pate=pate;
		
		if(taille==Taille.Medium){
			this.prix=recette.getPrixM();
		}else if(taille==Taille.Large){
			this.prix=recette.getPrixL();
		}
		else{
			this.prix=recette.getPrixXL();
		}
	
		if(pate==TypePate.MozzaCrust){
			this.prix=this.prix+pate.getPrix();
		}else if(pate==TypePate.Pan){
			this.prix=this.prix+pate.getPrix();
		}
		else{
			this.prix=this.prix+pate.getPrix();
		}
	
	
	}

	public double getPrix() {
		return prix;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public Recette getRecette() {
		return recette;
	}
	
	public void setRecette(Recette recette) {
		this.recette = recette;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Taille getTaille() {
		return taille;
	}

	@Override
	public String toString() {
		return "Pizza "+getTaille()+" "+pate+" - "+getRecette()+" - Prix : "+getPrix()+"€";//AJOUTER TYPE PATE
		//return "Pizza [id=" + id + ", prix=" + prix + ", recette=" + recette + "]";
	}





}
