package com.realestate.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.realestate.app.model.Credentials;
import com.realestate.app.repository.CredentialsRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Credentials credentials = credentialsRepository.findByUsername(username);
        
        if (credentials == null) {
            throw new UsernameNotFoundException("Utente non trovato: " + username);
        }
        
        // Crea un'autorità basata sul ruolo dell'utente
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + credentials.getRole().name());
        
        // Crea e restituisce un oggetto UserDetails con username, password e autorità
        return new User(
            credentials.getUsername(),
            credentials.getPassword(),
            Collections.singletonList(authority)
        );
    }
}
