package pizzayolo.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("S")
public class Salle extends Commande {

	@Enumerated(EnumType.STRING)
	@Column(name = "emplacement")
	@JsonView({JsonViews.CommandeWithItem.class})
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
