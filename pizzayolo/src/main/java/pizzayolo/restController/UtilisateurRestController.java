
package pizzayolo.restController;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import pizzayolo.entity.Adresse;
import pizzayolo.entity.JsonViews;
import pizzayolo.entity.Utilisateur;
import pizzayolo.services.UtilisateurService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/utilisateur")
public class UtilisateurRestController {

	@Autowired
	private UtilisateurService utilisateurService;

	@GetMapping("")
	@JsonView(JsonViews.UtilisateurWithAdresse.class)
	public List<Utilisateur> getAll() {
		return utilisateurService.getAll();
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Common.class)
	public Utilisateur create(@Valid @RequestBody Utilisateur utilisateur, BindingResult br) {
		return utilisateurService.create(utilisateur);
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.UtilisateurWithAdresse.class)
	public Utilisateur getById(@PathVariable Long id) {
		return utilisateurService.getById(id);
	}

	@DeleteMapping("/{id}")
	@JsonView({JsonViews.UtilisateurWithAdresse.class,JsonViews.Common.class})
	public void delete(Utilisateur user) {
		utilisateurService.delete(user);
	}

	@GetMapping("/{id}/adresse")
	@JsonView(JsonViews.UtilisateurWithAdresse.class)
	public Utilisateur getByIdWithAdresse(@PathVariable Long id) {
		return utilisateurService.getByIdWithAdresse(id);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.UtilisateurWithAdresse.class)
	public Utilisateur partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Long id) {
		Utilisateur utilisateur = utilisateurService.getById(id);
		Adresse adresse=new Adresse();
		// utilisateur.setNom(fields.get("nom").toString());

		fields.forEach((k, v) -> {
			System.out.println(v);
			if (k.equals("adresse")) {   //adresse et employe
				System.out.println(v);
				Map<String, Object> map=(Map<String, Object>) v;
				map.forEach((kAdresse,vAdresse)->{
					Field fAdresse = ReflectionUtils.findField(Adresse.class, kAdresse);
					ReflectionUtils.makeAccessible(fAdresse);
					ReflectionUtils.setField(fAdresse, adresse, vAdresse);
				});
				utilisateur.setAdresse(adresse);
			}else {
			Field field = ReflectionUtils.findField(Utilisateur.class, k);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, utilisateur, v);
			 }
		});

		return utilisateurService.update(utilisateur);
	}

	@GetMapping("/mail/{mail}")
	@JsonView(JsonViews.Common.class)
	public boolean checkMail(@PathVariable String mail) {
		return utilisateurService.checkMailExist(mail);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.UtilisateurWithAdresse.class)
	public Utilisateur update(@Valid @RequestBody Utilisateur user, BindingResult br, @PathVariable Long id) {
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		return utilisateurService.update(user);
	}
}
