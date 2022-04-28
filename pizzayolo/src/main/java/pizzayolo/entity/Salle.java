package pizzayolo.entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import pizzayolo.util.Context;
@Entity
@DiscriminatorValue("S")
public class Salle extends Commande{
	private PlanSalle table;

  
	
	
	
  public Salle() {
		
	}


public PlanSalle getTable() {
		return table;
	}


	public void setTable(PlanSalle table) {
		this.table = table;
	}


public void voirTableLibre(){
	
		if (Context.getInstance().getTableLibre().isEmpty()) {System.out.println("Toutes les tables sont prises");}
		else {
		for (PlanSalle t : Context.getInstance().getTableLibre())
	{
		System.out.println(t);
	}
		}
	}
  
  
	public void prendreTable(PlanSalle PlanSalle){
		Context.getInstance().getTablePrise().add(PlanSalle);
		Context.getInstance().getTableLibre().remove(PlanSalle);
		
	}
	
	public void libererTable(PlanSalle PlanSalle){
		Context.getInstance().getTableLibre().add(PlanSalle);
		Context.getInstance().getTablePrise().remove(PlanSalle);
	}

	
	
}
