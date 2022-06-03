package pizzayolo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizzayolo.entity.Boisson;
import pizzayolo.exception.ExceptionPizzayolo;
import pizzayolo.repositories.BoissonRepository;

@Service
public class BoissonService {
	@Autowired
	private BoissonRepository boissonRepository;

	public List<Boisson> getAll() {
		return boissonRepository.findAll();
	}

	public Boisson getById(Long id) {
		return boissonRepository.findById(id).orElseThrow(ExceptionPizzayolo::new);
	}

	public Boisson create(Boisson boisson) {
		return boissonRepository.save(boisson);
	}

	public Boisson update(Boisson boisson) {
		// si version dans boisson
		// Boisson boissonEnBase = getById(boisson.getId());
		// boisson.setVersion(boissonEnBase.getVersion());
		return boissonRepository.save(boisson);
	}

	public void delete(Boisson boisson) {
		boissonRepository.delete(boisson);
	}

	public void deleteById(Long id) {
		boissonRepository.deleteById(id);
	}

}
