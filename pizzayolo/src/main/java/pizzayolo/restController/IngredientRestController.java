package pizzayolo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import pizzayolo.entity.Ingredient;
import pizzayolo.entity.JsonViews;
import pizzayolo.services.IngredientService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ingredient")
public class IngredientRestController {

	@Autowired
	IngredientService ingredientservice;

	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Ingredient> getAll() {
		return ingredientservice.getAll();
	}

}
