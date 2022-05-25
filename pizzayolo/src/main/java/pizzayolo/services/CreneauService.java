package pizzayolo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizzayolo.entity.Creneau;
import pizzayolo.exception.ExceptionPizzayolo;
import pizzayolo.repositories.CreneauRepository;

@Service
public class CreneauService {

	@Autowired
	private CreneauRepository creneauRepository;
/*
// il nous faut remonter les cr�anux pour une personne � partir entre 2 dates
	public List<Creneau> getByIdwithdate(Long id, LocalDate debut, LocalDate fin) {
		return creneauRepository.findByIdWhithDate(id, debut, fin);
	}

//il nous faut remonter tout les cr�naux entre 2 dates 
	public List<Creneau> getByDate(LocalDate debut, LocalDate fin) {
		return creneauRepository.findByDate(debut, fin);
	}
*/
 
	public List<Creneau> getAll() {
		return creneauRepository.findAll();
	}

	public Creneau getById(Long id) {
		return creneauRepository.findById(id).orElseThrow(ExceptionPizzayolo::new);
	}

	public Creneau create(Creneau creneau) {
		return creneauRepository.save(creneau);
	}

	public Creneau update(Creneau creneau) {

		return creneauRepository.save(creneau);
	}

	public void delete(Creneau creneau) {
		creneauRepository.delete(creneau);
	}

	public void deleteById(Long id) {
		creneauRepository.deleteById(id);
	}

}
