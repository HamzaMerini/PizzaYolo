package pizzayolo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizzayolo.entity.Recette;
import pizzayolo.exception.ExceptionPizzayolo;
import pizzayolo.repositories.RecetteRepository;

@Service
public class RecetteService {
	@Autowired
	private RecetteRepository recetteRepository;

	public List<Recette> getAll() {
		return recetteRepository.findAll();
	}

	public Recette getById(Long id) {
		return recetteRepository.findById(id).orElseThrow(ExceptionPizzayolo::new);
	}

	public void create(Recette recette) {
		recetteRepository.save(recette);
	}

	public Recette update(Recette recette) {
		// si version dans recette
		// Recette recetteEnBase = getById(recette.getId());
		// recette.setVersion(recetteEnBase.getVersion());
		return recetteRepository.save(recette);
	}

	public void delete(Recette recette) {
		recetteRepository.delete(recette);
	}

	public void deleteById(Long id) {
		recetteRepository.deleteById(id);
	}
}
