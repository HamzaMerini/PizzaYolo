package pizzayolo.entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


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



}




