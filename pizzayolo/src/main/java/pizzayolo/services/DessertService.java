package pizzayolo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizzayolo.entity.Dessert;
import pizzayolo.exception.ExceptionPizzayolo;
import pizzayolo.repositories.DessertRepository;

@Service
public class DessertService {
	@Autowired
	private DessertRepository dessertRepository;

	public List<Dessert> getAll() {
		return dessertRepository.findAll();
	}

	public Dessert getById(Long id) {
		return dessertRepository.findById(id).orElseThrow(ExceptionPizzayolo::new);
	}

	public void create(Dessert dessert) {
		dessertRepository.save(dessert);
	}

	public Dessert update(Dessert dessert) {
		// si version dans dessert
		// Dessert dessertEnBase = getById(dessert.getId());
		// dessert.setVersion(dessertEnBase.getVersion());
		return dessertRepository.save(dessert);
	}

	public void delete(Dessert dessert) {
		dessertRepository.delete(dessert);
	}

	public void deleteById(Long id) {
		dessertRepository.deleteById(id);
	}
}
