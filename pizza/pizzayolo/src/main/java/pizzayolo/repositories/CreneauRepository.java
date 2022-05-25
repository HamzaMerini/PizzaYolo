package pizzayolo.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pizzayolo.entity.Creneau;

public interface CreneauRepository extends JpaRepository<Creneau, Long> {

// il nous faut remonter les créanux pour une personne à partir entre 2 dates
	@Query("select c from crenaux left join fetch c.employe as e where e.id=:id and c.date>=:debut and c.date<=:fin")
	List <Creneau> findByIdWhithDate(@Param("id") Long id, @Param("debut") LocalDate debut,
			@Param("fin") LocalDate fin);

//il nous faut remonter tout les crénaux entre 2 dates 
@Query("select c from crenaux where c.date>=:debut and c.date<=:fin")
	List <Creneau> findByDate(@Param("debut") LocalDate debut,
			@Param("fin") LocalDate fin);
}
