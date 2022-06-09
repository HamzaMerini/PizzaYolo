package pizzayolo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import pizzayolo.entity.JsonViews;
import pizzayolo.entity.Recette;
import pizzayolo.services.RecetteService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/recette")
public class RecetteRestController {

	public RecetteRestController() {
		System.out.println("rest");
	}

	@Autowired
	RecetteService recetteservice;

	@JsonView(JsonViews.RecetteWithIngredient.class)
	@GetMapping("")
	public List<Recette> getAll() {
		return recetteservice.getAll();
	}

	@JsonView(JsonViews.RecetteWithIngredient.class)
	@GetMapping("/{id}")
	public Recette getById(@PathVariable Long id)  {
		return recetteservice.getById(id);
	}

	
}
