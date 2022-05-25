package pizzayolo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import pizzayolo.entity.Commande;
import pizzayolo.entity.JsonViews;
import pizzayolo.services.CommandeService;


@RestController
@RequestMapping("/api/commande")
public class CommandeRestController {

	@Autowired
	private CommandeService commandeService;

//	@JsonView(JsonViews.CommandeWithItem.class)
//	@GetMapping("")
//	public List<Commande> getAll() {
//		return commandeService.getAll();
//	}

	
	@JsonView(JsonViews.CommandeWithItem.class)
	@GetMapping("")
	public List<Commande> getAllWithItem() {
		return commandeService.getAllWithItem();
	}
	
	
	@JsonView(JsonViews.CommandeWithItem.class)
	@PostMapping("/create")
	public Commande create(@RequestBody Commande commande) {
		return commandeService.create(commande);
	}
	
	@JsonView(JsonViews.CommandeWithItem.class)
	@PostMapping("/delete")
	public void delete(@RequestBody Commande commande) {
		commandeService.delete(commande);
	}
}
