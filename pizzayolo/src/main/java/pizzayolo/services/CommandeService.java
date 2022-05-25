package pizzayolo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizzayolo.entity.Commande;
import pizzayolo.entity.CommandeBoisson;
import pizzayolo.entity.CommandeDessert;
import pizzayolo.entity.Pizza;
import pizzayolo.exception.ExceptionPizzayolo;
import pizzayolo.repositories.CommandeRepository;
import pizzayolo.repositories.PizzaRepository;

@Service
public class CommandeService {
	@Autowired
	private CommandeRepository commandeRepository;

	@Autowired
	private CommandeBoissonService commandeBoissonService;

	@Autowired
	private CommandeDessertService commandeDessertService;

	@Autowired
	private PizzaRepository pizzaRepository;

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

	public Commande create(Commande commande) {// faire en sorte que au moment on on créer une commande on créer aussi les commandeBoisson associé et les CommandeDessert il faut aussi mettre la commande dans pizza et save 
		//commande.getBoissons(); <- renvoi la liste des commandeBoisson pour cette commande
		return commandeRepository.save(commande);
	}

	public Commande update(Commande commande) {
		if (!(commande.getBoissons().isEmpty())) {
			for (CommandeBoisson cb : commande.getBoissons()) {
				commandeBoissonService.create(cb);
			}
		}

		if (!(commande.getDesserts().isEmpty())) {
			for (CommandeDessert cd : commande.getDesserts()) {
				commandeDessertService.create(cd);
			}
		}

		if (!(commande.getPizzas().isEmpty())) {
			for (Pizza p : commande.getPizzas()) {
				p.setCommandePizza(commande);
				pizzaRepository.save(p);
			}
		}

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
