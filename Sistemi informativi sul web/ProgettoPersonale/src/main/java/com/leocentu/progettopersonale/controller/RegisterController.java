package com.leocentu.progettopersonale.controller;

import com.leocentu.progettopersonale.model.Credenziali;
import com.leocentu.progettopersonale.model.Musicista;
import com.leocentu.progettopersonale.model.Utente;
import com.leocentu.progettopersonale.service.CredenzialiService;
import com.leocentu.progettopersonale.service.AlbumService;
import com.leocentu.progettopersonale.service.MusicistaService;
import com.leocentu.progettopersonale.service.UtenteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
public class RegisterController {

    @Autowired
    private CredenzialiService credenzialiService;

    @Autowired
    private MusicistaService musicistaService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AlbumService albumService;

    @GetMapping("/register")
    public String showRegistrationForm(@RequestParam(value = "ruolo", required = false) Credenziali.Ruolo ruolo,
                                       Model model) {
        if (ruolo == null) {
            ruolo = Credenziali.Ruolo.MUSICISTA;
        }

        model.addAttribute("ruoli", Credenziali.Ruolo.values());
        model.addAttribute("ruoloSelezionato", ruolo);

        return "register";
    }

    @GetMapping("/aggiorna")
    public String aggiorna(@RequestParam Credenziali.Ruolo ruolo, Model model) {
        model.addAttribute("ruoli", Credenziali.Ruolo.values());
        model.addAttribute("ruoloSelezionato", ruolo);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String ruolo,
                               @RequestParam(required = false) String nome,
                               @RequestParam(required = false) String cognome,
                               @RequestParam(required = false) LocalDate dataNascita,
                               Model model) {

        Credenziali.Ruolo ruoloEnum = Credenziali.Ruolo.valueOf(ruolo.toUpperCase());
        String encodedPassword = passwordEncoder.encode(password);

        if (credenzialiService.existsByUsername(username)) {
            model.addAttribute("esistente", "Username già esistente");
            return "register";
        }

        try {
            Credenziali credenziali = new Credenziali(username, encodedPassword, ruoloEnum);
            credenzialiService.save(credenziali);

            if (ruoloEnum == Credenziali.Ruolo.MUSICISTA) {
                Musicista musicista = new Musicista();
                musicista.setNome(nome);
                musicista.setCognome(cognome);
                musicista.setDataNascita(dataNascita);
                musicista.setCredenziali(credenziali);
                musicistaService.save(musicista);
            } else if (ruoloEnum == Credenziali.Ruolo.UTENTE) {
                Utente utente = new Utente();
                utente.setNome(nome);
                utente.setCognome(cognome);
                utente.setDataNascita(dataNascita);
                utente.setCredenziali(credenziali);
                utenteService.save(utente);
            }

            model.addAttribute("success", "Credenziali salvate con successo! Loggati per sfruttare tutte le risorse del sito!");
            return "login";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Errore durante la registrazione. Riprova.");
            return "register";
        }
    }
}