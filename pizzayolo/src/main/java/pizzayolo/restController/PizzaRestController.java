package pizzayolo.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import pizzayolo.entity.JsonViews;
import pizzayolo.entity.Pizza;
import pizzayolo.services.PizzaService;
import pizzayolo.services.RecetteService;


@RestController
@RequestMapping("/api/pizza")
public class PizzaRestController {

	
	@Autowired
	PizzaService pizzaService;
	// cr�er une pizza 

	@Autowired
	RecetteService recetteService;
	
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Pizza> getAll() {
		return pizzaService.getAll();
	}
	
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Pizza getById(@PathVariable Long id) {
		return pizzaService.getById(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Common.class)
	public Pizza create(@Valid @RequestBody Pizza pizza, BindingResult br) {
		return pizzaService.create(pizza);
	}
	
	
	
	
	
}
