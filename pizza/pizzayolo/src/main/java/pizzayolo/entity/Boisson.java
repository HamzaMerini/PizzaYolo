package pizzayolo.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@SequenceGenerator(name = "seqBoisson", sequenceName = "seq_commande", initialValue = 1, allocationSize = 1)
@Table(name="boisson")
public class Boisson {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqBoisson")
	private Integer id;
	private String nom;
    private double prix;

	

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
		Boisson other = (Boisson) obj;
		return Objects.equals(id, other.id);
	}


	public Boisson() {
		super();
	}


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
