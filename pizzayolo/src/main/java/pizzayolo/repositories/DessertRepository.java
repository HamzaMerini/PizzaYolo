package pizzayolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzayolo.entity.Dessert;

public interface DessertRepository extends JpaRepository<Dessert, Long>{

}
