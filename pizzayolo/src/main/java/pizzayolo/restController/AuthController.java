package pizzayolo.restController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import pizzayolo.entity.JsonViews;
import pizzayolo.entity.Utilisateur;
import pizzayolo.services.UtilisateurService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UtilisateurService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@PostMapping("/inscription")
	@PreAuthorize("isAnonymous()")
	@JsonView(JsonViews.Common.class)
	public Utilisateur inscription(@Valid @RequestBody Utilisateur user, BindingResult br) {
		
		if (br.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		user.setMdp(passwordEncoder.encode(user.getMdp()));
		
		Utilisateur result = userService.create(user);
		
		if(result==null){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		return result;
	}

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public Utilisateur getUser(@AuthenticationPrincipal Utilisateur user) {
		return user;
	}
}
