package pizzayolo.restController;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import pizzayolo.entity.Boisson;
import pizzayolo.entity.BoissonAngular;
import pizzayolo.entity.Commande;
import pizzayolo.entity.CommandeAngular;
import pizzayolo.entity.CommandeBoisson;
import pizzayolo.entity.CommandeBoissonKey;
import pizzayolo.entity.CommandeDessert;
import pizzayolo.entity.CommandeDessertKey;
import pizzayolo.entity.Dessert;
import pizzayolo.entity.DessertAngular;
import pizzayolo.entity.JsonViews;
import pizzayolo.entity.Livraison;
import pizzayolo.entity.Pizza;
import pizzayolo.entity.PlanSalle;
import pizzayolo.entity.Salle;
import pizzayolo.entity.Utilisateur;
import pizzayolo.services.CommandeBoissonService;
import pizzayolo.services.CommandeDessertService;
import pizzayolo.services.CommandeService;
import pizzayolo.services.PizzaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/commande")
public class CommandeRestController {

	@Autowired
	private CommandeService commandeService;

	@Autowired
	private CommandeBoissonService commandeBoissonService;

	@Autowired
	private CommandeDessertService commandeDessertService;

	@Autowired
	private PizzaService pizzaService;

	@JsonView(JsonViews.CommandeWithItem.class)
	@GetMapping("/all")
	public List<Commande> getAll() {
		return commandeService.getAll();
	}

	@JsonView(JsonViews.CommandeWithItem.class)
	@GetMapping("")
	public List<Commande> getAllWithItem() {
		return commandeService.getAllWithItem();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.CommandeWithItem.class)
	public Commande getById(@PathVariable Long id) {
		return commandeService.getById(id);
	}

	@JsonView(JsonViews.CommandeWithItem.class)
	@PostMapping("/create")
	public Commande create(@AuthenticationPrincipal Utilisateur utilisateur, @RequestBody CommandeAngular commandeAngular ) {
		// tranformer la commande Angular en Commande 
		System.out.println("commandeAngular qui arrive dans le restController : ");
		System.out.println(commandeAngular);
		
		if(commandeAngular.getTypeCommande().equals("Livraison")) {
			Livraison livraison = new Livraison();
			livraison.setClientTicket(commandeAngular.getClientTicket());
			livraison.setDateTicket(LocalDate.now());
			livraison.setHeureSouhaite(commandeAngular.getheureSouhaite());
			livraison.setPrixTotal(commandeAngular.getPrixTotal());

			System.out.println("livraison qui est sauvegardé ");
			System.out.println(livraison);
			
			System.out.println("LE MESSAGE COMMANDEANGULAR.GETHEURESOUHAITE dans commandeAngular:: ");
			System.out.println(commandeAngular.getheureSouhaite());
			
			Commande commande = commandeService.create(livraison);
			
		

			if(!(commandeAngular.getBoissons().isEmpty())) {
			for(BoissonAngular b : commandeAngular.getBoissons()) {  // créer la clef puis créer l'objet commandeBoisson 
				Boisson boisson = new Boisson();
				boisson.setId(b.getId());
				boisson.setNom(b.getNom());
				boisson.setPrix(b.getPrix());
				CommandeBoissonKey cbk =new CommandeBoissonKey(boisson, commande); 
				CommandeBoisson cb =new CommandeBoisson(cbk,b.getQuantite());
				commandeBoissonService.create(cb);

			}}

			if(!(commandeAngular.getDesserts().isEmpty())) {
			for(DessertAngular d : commandeAngular.getDesserts()) {  
				Dessert dessert = new Dessert();
				dessert.setId(d.getId());
				dessert.setNom(d.getNom());
				dessert.setPrix(d.getPrix());
				
				CommandeDessertKey cdk =new CommandeDessertKey(dessert, commande); 
				CommandeDessert cd =new CommandeDessert(cdk,d.getQuantite());
				commandeDessertService.create(cd);

			}}

			if(!(commandeAngular.getPizzas().isEmpty())) {
			for(Pizza p : commandeAngular.getPizzas()) {p.setCommandePizza(commande);pizzaService.update(p);}
			return commande;
		}}



		else {
			Salle salle =new Salle();
			salle.setClientTicket(commandeAngular.getClientTicket());
			salle.setDateTicket(LocalDate.now());
			salle.setPrixTotal(commandeAngular.getPrixTotal());
			salle.setPlace(commandeAngular.getPlace());

			
			System.out.println("salle qui est sauvegardé : ");
			System.out.println(salle);
			
			Commande commande = commandeService.create(salle);

			for(BoissonAngular b : commandeAngular.getBoissons()) {  // créer la clef puis créer l'objet commandeBoisson 
				Boisson boisson = new Boisson();
				boisson.setId(b.getId());
				boisson.setNom(b.getNom());
				boisson.setPrix(b.getPrix());
				
				CommandeBoissonKey cbk =new CommandeBoissonKey(boisson, commande); 
				CommandeBoisson cb =new CommandeBoisson(cbk,b.getQuantite());
				System.out.println("cb commandeBoisson qui est envoyé en sauvegarde dans la boucle");
				System.out.println(cb);
				commandeBoissonService.create(cb);

			}

			for(DessertAngular d : commandeAngular.getDesserts()) {  
				Dessert dessert = new Dessert();
				dessert.setId(d.getId());
				dessert.setNom(d.getNom());
				dessert.setPrix(d.getPrix());
				
				
				CommandeDessertKey cdk =new CommandeDessertKey(dessert, commande); 
				CommandeDessert cd =new CommandeDessert(cdk,d.getQuantite());
				System.out.println("cd commadne dessert qui est envoyé en sauvegarde dans la boucle");
				System.out.println(cd);
				commandeDessertService.create(cd);

			}

			for(Pizza p : commandeAngular.getPizzas()) {p.setCommandePizza(commande);pizzaService.update(p);		
			}
			return commande;
		}
		
		
		return null;


		
	}

	@JsonView(JsonViews.CommandeWithItem.class)
	@PostMapping("/delete")
	public void delete(@RequestBody Commande commande) {
		commandeService.delete(commande);
	}
}
