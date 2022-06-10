package pizzayolo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizzayolo.entity.Commande;
import pizzayolo.entity.CommandeAngular;
import pizzayolo.entity.CommandeBoisson;
import pizzayolo.entity.CommandeBoissonKey;
import pizzayolo.entity.CommandeDessert;
import pizzayolo.entity.Livraison;
import pizzayolo.entity.Pizza;
import pizzayolo.entity.Salle;
import pizzayolo.entity.Taille;
import pizzayolo.exception.ExceptionPizzayolo;
import pizzayolo.repositories.CommandeRepository;

@Service
public class CommandeService {
	@Autowired
	private CommandeRepository commandeRepository;

	@Autowired
	private CommandeBoissonService commandeBoissonService;

	@Autowired
	private CommandeDessertService commandeDessertService;

	@Autowired
	private PizzaService pizzaService;

	@Autowired
	private BoissonService boissonService;

	@Autowired
	private DessertService dessertService;


	public List<Commande> getAll() {
		return commandeRepository.findAll();
	}

	public List<Commande> getAllWithItem() {
		return commandeRepository.findAllWithItem();
	}

	public List<CommandeBoisson> getAllBoisson() {
		return commandeBoissonService.getAllBoisson();
	}

	public List<CommandeDessert> getAllDessert() {
		return commandeDessertService.getAllDesserts();
	}

	public Commande getById(Long id) {
		return commandeRepository.findById(id).orElseThrow(ExceptionPizzayolo::new);
	}

	public Commande create(Commande commande) {
		
		return commandeRepository.save(commande);}
		
		

	public Commande update(Commande commande) {
	
		return commandeRepository.save(commande);
	}

	public void delete(Commande commande) {
		commandeRepository.delete(commande);
	}

	public void deleteById(Long id) {
		commandeRepository.deleteById(id);
	}

	

	
	public void afficherTicket(Commande commande) {

	}
}
