package pizzayolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzayolo.entity.Recette;

public interface RecetteRepository extends JpaRepository<Recette, Long>{

}
