package pizzayolo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizzayolo.entity.Utilisateur;
import pizzayolo.exception.ExceptionPizzayolo;
import pizzayolo.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	public List<Utilisateur> getAll() {
		return utilisateurRepository.findAll();
	}

	public Utilisateur getById(Long id) {
		return utilisateurRepository.findById(id).orElseThrow(ExceptionPizzayolo::new);
	}

	public Utilisateur getByMail(String mail) {
		return utilisateurRepository.findByMail(mail).orElseThrow(ExceptionPizzayolo::new);
	}

	public Utilisateur create(Utilisateur utilisateur) {
		String mail = utilisateur.getMail();
		if (!(utilisateurRepository.findByMail(mail).isEmpty())) {
			return null;
		} else {
			return utilisateurRepository.save(utilisateur);
		}
	}

	public Utilisateur update(Utilisateur utilisateur) {
		// si version dans utilisateur
		// Utilisateur utilisateurEnBase = getById(utilisateur.getId());
		// utilisateur.setVersion(utilisateurEnBase.getVersion());
		return utilisateurRepository.save(utilisateur);
	}

	public void delete(Utilisateur utilisateur) {
		utilisateurRepository.delete(utilisateur);
	}

	public void deleteById(Long id) {
		utilisateurRepository.deleteById(id);
	}

	public void afficherHistorique(Utilisateur utilisateur) {

	}

	public Utilisateur getByIdWithAdresse(Long id) {
		return utilisateurRepository.findByIdWithAdresse(id).orElseThrow(RuntimeException::new);
	}

}
