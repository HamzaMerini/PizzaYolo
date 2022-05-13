package pizzayolo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import pizzayolo.entity.Boisson;
import pizzayolo.entity.Boisson;
import pizzayolo.services.BoissonService;
import pizzayolo.entity.JsonViews;
import pizzayolo.services.BoissonService;

@RestController
@RequestMapping("/api/boisson")
public class BoissonRestController {

	@Autowired
	private BoissonService boissonService;

	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Boisson> getAll() {
		try {
			return boissonService.getAll();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	public Boisson create(@RequestBody Boisson boisson) {
		return boissonService.create(boisson);
	

}
}