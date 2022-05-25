package pizzayolo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import pizzayolo.entity.Commande;
import pizzayolo.services.CommandeService;
import pizzayolo.services.UtilisateurService;

@SpringBootTest
class PizzayoloApplicationTests {

	@Autowired
	UtilisateurService utilisateurService;

	@Autowired
	CommandeService commandeService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	
	void contextLoads() {
		
		Commande c1= commandeService.getById(17L);
		System.out.println(commandeService.getAllWithItem());

	}

}
