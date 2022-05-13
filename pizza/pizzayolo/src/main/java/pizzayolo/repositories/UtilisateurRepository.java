package pizzayolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzayolo.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

}
