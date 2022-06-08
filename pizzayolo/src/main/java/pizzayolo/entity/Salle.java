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

	
	@Column(name = "emplacement")
	@JsonView({JsonViews.CommandeWithItem.class})
	private String place;

	public Salle() {

	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}



}
