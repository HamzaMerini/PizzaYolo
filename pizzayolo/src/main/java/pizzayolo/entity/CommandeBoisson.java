package pizzayolo.entity;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="commande_boisson")
public class CommandeBoisson {
	@EmbeddedId
	private CommandeBoissonKey idCB;
	private int quantiteBoisson;
	
	
	public CommandeBoisson() {
		super();
	}
	public CommandeBoissonKey getIdCB() {
		return idCB;
	}
	public void setIdCB(CommandeBoissonKey idCB) {
		this.idCB = idCB;
	}
	public int getQuantiteBoisson() {
		return quantiteBoisson;
	}
	public void setQuantiteBoisson(int quantiteBoisson) {
		this.quantiteBoisson = quantiteBoisson;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idCB);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommandeBoisson other = (CommandeBoisson) obj;
		return Objects.equals(idCB, other.idCB);
	}
	

}
