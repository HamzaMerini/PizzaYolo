package pizzayolo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pizzayolo.entity.CommandeBoisson;
import pizzayolo.repositories.CommandeBoissonRepository;


@Service
public class CommandeBoissonService {

	@Autowired
	private CommandeBoissonRepository commandeBoissonRepository;

	public List<CommandeBoisson> getAllBoisson() {
		return commandeBoissonRepository.findAll();
	}

	public CommandeBoisson create(CommandeBoisson commandeBoisson) {// faire en sorte que au moment on on créer une commande on créer aussi les commandeBoisson associé et les CommandeDessert il faut aussi mettre la commande dans pizza et save 
		//commande.getBoissons(); <- renvoi la liste des commandeBoisson pour cette commande
		System.out.println(commandeBoisson);
		return commandeBoissonRepository.save(commandeBoisson);
	}

	public CommandeBoisson update(CommandeBoisson commandeBoisson) {
		// si version dans commande
		// Commande commandeEnBase = getById(commande.getId());
		// commande.setVersion(commandeEnBase.getVersion());
		
		return commandeBoissonRepository.save(commandeBoisson);
	}

	public void delete(CommandeBoisson commandeBoisson) {
		commandeBoissonRepository.delete(commandeBoisson);
	}




}
