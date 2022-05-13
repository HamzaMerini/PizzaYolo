package pizzayolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzayolo.entity.Livraison;

public interface LivraisonRepository extends JpaRepository<Livraison, Long>{

}
