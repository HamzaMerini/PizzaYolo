package pizzayolo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizzayolo.entity.Livraison;
import pizzayolo.exception.ExceptionPizzayolo;
import pizzayolo.repositories.LivraisonRepository;

@Service
public class LivraisonService {
	@Autowired
    private LivraisonRepository livraisonRepository;

    public List<Livraison> getAll() {
        return livraisonRepository.findAll();
    }

    public Livraison getById(Long id) {
        return livraisonRepository.findById(id).orElseThrow(ExceptionPizzayolo::new);
    }

    public void create(Livraison livraison) {
        livraisonRepository.save(livraison);
    }

    public Livraison update(Livraison livraison) {
        // si version dans livraison
        // Livraison livraisonEnBase = getById(livraison.getId());
        // livraison.setVersion(livraisonEnBase.getVersion());
        return livraisonRepository.save(livraison);
    }

    public void delete(Livraison livraison) {
        livraisonRepository.delete(livraison);
    }

    public void deleteById(Long id) {
        livraisonRepository.deleteById(id);
    }
}
