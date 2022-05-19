package pizzayolo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizzayolo.entity.Commande;
import pizzayolo.exception.ExceptionPizzayolo;
import pizzayolo.repositories.CommandeRepository;

@Service
public class CommandeService {
	@Autowired
	private CommandeRepository commandeRepository;
	
	

	public List<Commande> getAll() {
		return commandeRepository.findAll();
	}

	public Commande getById(Long id) {
		return commandeRepository.findById(id).orElseThrow(ExceptionPizzayolo::new);
	}

	public Commande create(Commande commande) {
		return commandeRepository.save(commande);
	}

	public Commande update(Commande commande) {
		// si version dans commande
		// Commande commandeEnBase = getById(commande.getId());
		// commande.setVersion(commandeEnBase.getVersion());
		return commandeRepository.save(commande);
	}

	public void delete(Commande commande) {
		commandeRepository.delete(commande);
	}

	public void deleteById(Long id) {
		commandeRepository.deleteById(id);
	}

	public void afficherTicket(Commande commande){
		
	}
}
