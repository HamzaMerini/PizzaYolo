package pizzayoloFront.restController;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import pizzayolo.entity.Utilisateur;
import pizzayolo.services.UtilisateurService;
import quest.entity.JsonViews;

//import quest.entity.JsonViews;


@RestController
@RequestMapping("/utilisateur")
public class UtilisateurRestController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@GetMapping("")
	//@JsonView(JsonViews.Common.class)
	public List<Utilisateur> getAll() {
		return utilisateurService.getAll();
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	//@JsonView(JsonViews.Common.class)
	public Utilisateur create(@Valid @RequestBody Utilisateur utilisateur, BindingResult br) {
		return utilisateurService.create(utilisateur);
	}
	
	@GetMapping("/{id}")
	//@JsonView(JsonViews.Common.class)
	public Utilisateur getById(@PathVariable Long id) {
		return utilisateurService.getById(id);
	}
	
	@GetMapping("/{id}/adresse")
	//@JsonView(JsonViews.UtilisateurWithAdresse.class)
	public Utilisateur getByIdWithAdresse(@PathVariable Long id) {
		return utilisateurService.getByIdWithAdresse(id);
	}
	
	
	@PatchMapping("/{id}")
	//@JsonView(JsonViews.Common.class)
	public Utilisateur partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
		Utilisateur utilisateur = utilisateurService.getById(id);
		// utilisateur.setNom(fields.get("nom").toString());

		fields.forEach((k, v) -> {
//			if (k.equals("attributQuiPoseProbleme")) {
//				;
//			}else {
				Field field = ReflectionUtils.findField(Utilisateur.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, utilisateur, v);
			//}
		});

		return utilisateurService.update(utilisateur);
	}
	

}
