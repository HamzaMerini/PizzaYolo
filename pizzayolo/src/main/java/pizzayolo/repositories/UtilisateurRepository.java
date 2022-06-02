package pizzayolo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pizzayolo.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	@Query("select u from Utilisateur u left join fetch u.adresse where u.id=:id")
    Optional<Utilisateur> findByIdWithAdresse(@Param("id") Long id);
   

    Optional<Utilisateur> findByMail(String mail);
}