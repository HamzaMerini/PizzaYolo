package pizzayolo.entity;
import pizzayolo.util.Context;

public class Salle extends Commande{
	

  
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
