package pizzayolo.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("S")
public class Salle extends Commande {

	@Enumerated(EnumType.STRING)
	@Column(name = "emplacement")
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
