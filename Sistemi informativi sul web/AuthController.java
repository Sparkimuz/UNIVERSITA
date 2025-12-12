package com.realestate.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.realestate.app.model.Agent;
import com.realestate.app.model.Credentials;
import com.realestate.app.model.User;
import com.realestate.app.service.AgentService;
import com.realestate.app.service.CredentialsService;
import com.realestate.app.service.UserService;
import com.realestate.app.validation.CredentialsValidator;
import com.realestate.app.validation.UserValidator;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private CredentialsService credentialsService;
    
    @Autowired
    private AgentService agentService;
    
    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private CredentialsValidator credentialsValidator;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    // Mostra la pagina di login
    @GetMapping("/login")
    public String showLoginForm() {
        return "auth/login";
    }

    // Gestisce il reindirizzamento dopo il login
    @GetMapping("/login-success")
    public String loginSuccess() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        if (auth != null && auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin/index.html";
        }
        
        return "redirect:/agent/index.html";
    }

    // Mostra la pagina di registrazione
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userForm", new User());
        model.addAttribute("credentialsForm", new Credentials());
        return "auth/register";
    }

    // Gestisce la registrazione di un nuovo utente
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("userForm") User user,
                              BindingResult userBindingResult,
                              @Valid @ModelAttribute("credentialsForm") Credentials credentials,
                              BindingResult credentialsBindingResult,
                              @RequestParam("image") MultipartFile image,
                              @RequestParam(value = "agentId", required = false) Long agentId,
                              Model model) {
        
        userValidator.validate(user, userBindingResult);
        credentialsValidator.validate(credentials, credentialsBindingResult);
        
        if (userBindingResult.hasErrors() || credentialsBindingResult.hasErrors()) {
            return "auth/register";
        }
        
        // Gestione del caricamento dell'immagine
        if (!image.isEmpty()) {
            // Logica per salvare l'immagine e impostare l'URL
            // user.setImageUrl(savedImageUrl);
        }
        
        // Salva le credenziali
        credentials.setRole(Credentials.Role.AGENT); // Default role
        credentialsService.save(credentials);
        
        // Collega le credenziali all'utente
        user.setCredentials(credentials);
        
        // Collega l'utente all'agente se specificato
        if (agentId != null) {
            agentService.findById(agentId).ifPresent(agent -> {
                user.setAgent(agent);
                agent.setUser(user);
                agentService.update(agent);
            });
        }
        
        // Salva l'utente
        userService.save(user);
        
        // Autentica automaticamente l'utente
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        return "redirect:/login-success";
    }

    // Mostra la pagina di registrazione per un nuovo agente
    @GetMapping("/register-agent")
    public String showAgentRegistrationForm(Model model) {
        model.addAttribute("userForm", new User());
        model.addAttribute("credentialsForm", new Credentials());
        model.addAttribute("agentForm", new Agent());
        return "auth/register-agent";
    }

    // Gestisce la registrazione di un nuovo agente
    @PostMapping("/register-agent")
    public String registerAgent(@Valid @ModelAttribute("userForm") User user,
                               BindingResult userBindingResult,
                               @Valid @ModelAttribute("credentialsForm") Credentials credentials,
                               BindingResult credentialsBindingResult,
                               @Valid @ModelAttribute("agentForm") Agent agent,
                               BindingResult agentBindingResult,
                               @RequestParam("image") MultipartFile image,
                               Model model) {
        
        userValidator.validate(user, userBindingResult);
        credentialsValidator.validate(credentials, credentialsBindingResult);
        
        if (userBindingResult.hasErrors() || credentialsBindingResult.hasErrors() || agentBindingResult.hasErrors()) {
            return "auth/register-agent";
        }
        
        // Gestione del caricamento dell'immagine
        if (!image.isEmpty()) {
            // Logica per salvare l'immagine e impostare l'URL
            // user.setImageUrl(savedImageUrl);
            // agent.setImageUrl(savedImageUrl);
        }
        
        // Salva l'agente
        agentService.save(agent);
        
        // Salva le credenziali
        credentials.setRole(Credentials.Role.AGENT);
        credentialsService.save(credentials);
        
        // Collega le credenziali all'utente
        user.setCredentials(credentials);
        
        // Collega l'utente all'agente
        user.setAgent(agent);
        agent.setUser(user);
        
        // Salva l'utente
        userService.save(user);
        
        // Aggiorna l'agente con il riferimento all'utente
        agentService.update(agent);
        
        // Autentica automaticamente l'utente
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        return "redirect:/login-success";
    }

    // Mostra la pagina di logout
    @GetMapping("/logout")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "redirect:/login?logout";
    }
}
