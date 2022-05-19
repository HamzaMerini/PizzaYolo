package pizzayolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzayolo.entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
