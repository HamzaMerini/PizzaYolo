package pizzayolo.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="commande_dessert")
public class CommandeDessert {
	@EmbeddedId
	@JsonView(JsonViews.Common.class)
	@Column(name="id_commande_dessert")
	private CommandeDessertKey idCD;
	@Column(name="quantite_dessert")
	private int quantiteDessert;

	public int getQuantiteDessert() {
		return quantiteDessert;
	}

	public void setQuantiteDessert(int quantiteDessert) {
		this.quantiteDessert = quantiteDessert;
	}

	public CommandeDessert() {
		super();
	}
	
	
	

	public CommandeDessert(CommandeDessertKey idCD, int quantiteDessert) {
		super();
		this.idCD = idCD;
		this.quantiteDessert = quantiteDessert;
	}

	public CommandeDessertKey getId() {
		return idCD;
	}

	public void setId(CommandeDessertKey id) {
		this.idCD = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCD);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommandeDessert other = (CommandeDessert) obj;
		return Objects.equals(idCD, other.idCD);
	}
	

}
