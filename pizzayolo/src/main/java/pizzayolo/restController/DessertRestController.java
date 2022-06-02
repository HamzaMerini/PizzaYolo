package pizzayolo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import pizzayolo.entity.Dessert;
import pizzayolo.entity.JsonViews;
import pizzayolo.services.DessertService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/dessert")
public class DessertRestController {

	@Autowired
	private DessertService dessertService;

	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Dessert> getAll() {
		return dessertService.getAll();
	}

	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Dessert create(@RequestBody Dessert dessert) {
		return dessertService.create(dessert);
	}
}
