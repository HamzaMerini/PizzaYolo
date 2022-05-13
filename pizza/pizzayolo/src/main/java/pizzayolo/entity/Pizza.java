package pizzayolo.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pizzayolo.entity.Recette;

@Entity

@SequenceGenerator(name = "seqPizza", sequenceName = "seq_pizza", initialValue = 1, allocationSize = 1)
@Table(name = "pizza")
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPizza")
	private Long id;
	private String nom;
	
	
	@ManyToOne
	@JoinColumn(name = "numticket_id", foreignKey = @ForeignKey(name = "PIZZA_NUMTICKET_ID_FK"))
	private Commande commandePizza;

	

	private double prix;
	
	@ManyToOne
	@JoinColumn(name="recette", foreignKey =@ForeignKey(name="PIZZA_RECETTE_ID_FK"))
	private Recette recette;

	private Taille taille;
	private TypePate pate;


//	public Pizza(Recette recette,Taille taille,TypePate pate) {
//		
//		this.recette = recette;
//		this.taille = taille;
//		this.pate=pate;
//		
//		if(taille==Taille.Medium){
//			this.prix=recette.getPrixM();
//		}else if(taille==Taille.Large){
//			this.prix=recette.getPrixL();
//		}
//		else{
//			this.prix=recette.getPrixXL();
//		}
//	
//		if(pate==TypePate.MozzaCrust){
//			this.prix=this.prix+pate.getPrix();
//		}else if(pate==TypePate.Pan){
//			this.prix=this.prix+pate.getPrix();
//		}
//		else{
//			this.prix=this.prix+pate.getPrix();
//		}
//	
//	
//	}

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
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Taille getTaille() {
		return taille;
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
		Pizza other = (Pizza) obj;
		return Objects.equals(id, other.id);
	}

	
	}






