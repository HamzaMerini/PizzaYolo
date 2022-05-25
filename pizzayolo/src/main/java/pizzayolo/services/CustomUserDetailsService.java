package pizzayolo.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UtilisateurService userService;

	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
		return userService.getByMail(mail);
	}

}
