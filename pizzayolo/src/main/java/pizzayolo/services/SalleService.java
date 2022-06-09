package pizzayolo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizzayolo.entity.Salle;
import pizzayolo.exception.ExceptionPizzayolo;
import pizzayolo.repositories.SalleRepository;

@Service
public class SalleService {
    @Autowired
    private SalleRepository salleRepository;

    public List<Salle> getAll() {
        return salleRepository.findAll();
    }

    public Salle getById(Long id) {
        return salleRepository.findById(id).orElseThrow(ExceptionPizzayolo::new);
    }

    public void create(Salle salle) {
        salleRepository.save(salle);
    }

    public Salle update(Salle salle) {
        // si version dans salle
        // Salle salleEnBase = getById(salle.getId());
        // salle.setVersion(salleEnBase.getVersion());
        return salleRepository.save(salle);
    }

    public void delete(Salle salle) {
        salleRepository.delete(salle);
    }

    public void deleteById(Long id) {
        salleRepository.deleteById(id);
    }
}