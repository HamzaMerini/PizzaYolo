package pizzayolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzayolo.entity.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long>{

}
