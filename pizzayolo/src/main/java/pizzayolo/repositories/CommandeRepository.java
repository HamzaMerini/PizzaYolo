package pizzayolo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pizzayolo.entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

	@Query("select c from Commande as c left join fetch c.pizzas as p "+
									   "left join fetch c.boissons as b"+
									   "left join fetch c.desserts as d")
	
	List<Commande>findAllWithItem();
	
	
	@Query("select c from Commande as c where c.clientTicket=:utilisateurid")
	List<Commande>findbyClient(@Param("utilisateurid") Long id);

	
}
