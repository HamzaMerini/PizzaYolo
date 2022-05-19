package pizzayolo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizzayolo.entity.Ingredient;
import pizzayolo.exception.ExceptionPizzayolo;
import pizzayolo.repositories.IngredientRepository;

@Service
public class IngredientService {
	@Autowired
	private IngredientRepository ingredientRepository;

	public List<Ingredient> getAll() {
		return ingredientRepository.findAll();
	}

	public Ingredient getById(Long id) {
		return ingredientRepository.findById(id).orElseThrow(ExceptionPizzayolo::new);
	}

	public void create(Ingredient ingredient) {
		ingredientRepository.save(ingredient);
	}

	public Ingredient update(Ingredient ingredient) {
		// si version dans ingredient
		// Ingredient ingredientEnBase = getById(ingredient.getId());
		// ingredient.setVersion(ingredientEnBase.getVersion());
		return ingredientRepository.save(ingredient);
	}

	public void delete(Ingredient ingredient) {
		ingredientRepository.delete(ingredient);
	}

	public void deleteById(Long id) {
		ingredientRepository.deleteById(id);
	}
}
