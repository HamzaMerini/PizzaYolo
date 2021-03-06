package pizzayolo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

//import hypothetique a adapter en fonction du boulot de chacun 
import pizzayolo.config.PizzayoloConfig;
import pizzayolo.entity.Adresse;
import pizzayolo.entity.Utilisateur;
import pizzayolo.services.UtilisateurService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { PizzayoloConfig.class })
@Transactional
@Rollback     // les modif en BDD faites pendant le test ne sont pas sauvegardees  
// si on veut sauvegarder en BDD les modif d'un test il faut anoter ce test avec @commit


public class UtilisateurServiceTest {
	@Autowired
	UtilisateurService utilisateurService;   // injection de commande service pour nos test sur cette page
	@Test
	public void uneMethode() {
		Assertions.assertTrue(true);
	}

	//pour faire un test @Test puit creer une methode qui doit verifier assert...
	// L�annotation @Disabled permet de d�sactiverun test.







}
