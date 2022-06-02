package pizzayolo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizzayolo.entity.Employe;
import pizzayolo.exception.ExceptionPizzayolo;
import pizzayolo.repositories.EmployeRepository;

@Service
public class EmployeService {
	@Autowired
	private EmployeRepository employeRepository;

	public List<Employe> getAll() {
		return employeRepository.findAll();
	}

	public Employe getById(Long id) {
		return employeRepository.findById(id).orElseThrow(ExceptionPizzayolo::new);
	}

	public void create(Employe employe) {
		employeRepository.save(employe);
	}

	public Employe update(Employe employe) {
		// si version dans employe
		// Employe employeEnBase = getById(employe.getId());
		// employe.setVersion(employeEnBase.getVersion());
		return employeRepository.save(employe);
	}

	public void delete(Employe employe) {
		employeRepository.delete(employe);
	}

	public void deleteById(Long id) {
		employeRepository.deleteById(id);
	}
}
