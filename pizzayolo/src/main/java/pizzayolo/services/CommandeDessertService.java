package pizzayolo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizzayolo.entity.CommandeDessert;
import pizzayolo.repositories.CommandeDessertRepository;

@Service
public class CommandeDessertService {

	@Autowired
	private CommandeDessertRepository commandeDessertRepository;


	public List<CommandeDessert> getAllDesserts() {
		return commandeDessertRepository.findAll();
	}

	public CommandeDessert create(CommandeDessert commandeDessert) {// faire en sorte que au moment on on créer une commande on créer aussi les commandeDessert associé et les CommandeDessert il faut aussi mettre la commande dans pizza et save 
		//commande.getBoissons(); <- renvoi la liste des commandeDessert pour cette commande
		
		return commandeDessertRepository.save(commandeDessert);
	}

	public CommandeDessert update(CommandeDessert commandeDessert) {
		// si version dans commande
		// Commande commandeEnBase = getById(commande.getId());
		// commande.setVersion(commandeEnBase.getVersion());
		return commandeDessertRepository.save(commandeDessert);
	}

	public void delete(CommandeDessert commandeDessert) {
		commandeDessertRepository.delete(commandeDessert);
	}
}
