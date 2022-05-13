package pizzayolo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzayolo.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>{

}
