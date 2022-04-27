package pizzayolo.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "creneau")
@SequenceGenerator(name = "seqCreneau", sequenceName = "seq_creneau", initialValue = 1, allocationSize = 1)
public class Creneau {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCreneau")
	@Column(name="id")
	private Long id;
	private LocalDate date;//a quoi ca sert ???
	@Column(name="debut")
	private LocalTime debut;
	@Column(name="fin")
	private LocalTime fin;

	@ManyToMany(mappedBy = "creneaux")
	private Employee employe;

	public Creneau() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getDebut() {
		return debut;
	}

	public void setDebut(LocalTime debut) {
		this.debut = debut;
	}

	public LocalTime getFin() {
		return fin;
	}

	public void setFin(LocalTime fin) {
		this.fin = fin;
	}

	public Employee getEmploye() {
		return employe;
	}

	public void setEmploye(Employee employe) {
		this.employe = employe;
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
		Creneau other = (Creneau) obj;
		return Objects.equals(id, other.id);
	}

}
