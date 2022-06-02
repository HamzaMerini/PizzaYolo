package pizzayolo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizzayolo.entity.Commande;
import pizzayolo.entity.CommandeBoisson;
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

	public Commande create(Commande commande) {// faire en sorte que au moment on on créer une commande on créer aussi les commandeBoisson associé et les CommandeDessert il faut aussi mettre la commande dans pizza et save 
		//commande.getBoissons(); <- renvoi la liste des commandeBoisson pour cette commande
		return commandeRepository.save(commande);
	}

	public Commande update(Commande commande) {
		double prix=0;
		if (!(commande.getBoissons()==null)) {
			for (CommandeBoisson cb : commande.getBoissons()) {
				
				if(commande.getClientTicket().getType().equals("employe") && commande instanceof Salle) {
					if (cb.getIdCB().getBoisson().getNom().contains("33") || cb.getIdCB().getBoisson().getNom().contains("50")) {
						cb.getIdCB().getBoisson().setPrix(1);
					}else {
						cb.getIdCB().getBoisson().setPrix(2);
					}
				}
				cb.setPrix(cb.getIdCB().getBoisson().getPrix());
				prix=prix+cb.getPrix()*cb.getQuantiteBoisson();
				commandeBoissonService.create(cb);
			}
		}

		if (!(commande.getDesserts()==null)) {
			for (CommandeDessert cd : commande.getDesserts()) {
				if(commande.getClientTicket().getType().equals("employe") && commande instanceof Salle) {
					if (cd.getIdCD().getDessert().getNom().contains("465ml")) {
						cd.getIdCD().getDessert().setPrix(5);
					}else if (cd.getIdCD().getDessert().getNom().contains("100ml")) {
						cd.getIdCD().getDessert().setPrix(2);
					}else {
						cd.getIdCD().getDessert().setPrix(1.8);
					}
					
				}
				
				cd.setPrix(cd.getIdCD().getDessert().getPrix());
				prix=prix+cd.getPrix()*cd.getQuantiteDessert();
				commandeDessertService.create(cd);
			}
		}

		if (!(commande.getPizzas()==null)) {
			for (Pizza p : commande.getPizzas()) {
				p.setCommandePizza(commande);
				
				if(commande.getClientTicket().getType().equals("employe") && commande instanceof Salle) {
					if (p.getTaille().equals(Taille.Medium)) {
						p.setPrix(5);
					} else if (p.getTaille().equals(Taille.Large)) {
						p.setPrix(6);
					} else {
						p.setPrix(8);
					}
				}
				
				
				if(commande instanceof Livraison) {
					p.setPrix(p.getPrix()+2);
				}
				
				prix=prix+p.getPrix();
				pizzaService.update(p);
			}
	}
		
		commande.setPrixTotal(prix);
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
