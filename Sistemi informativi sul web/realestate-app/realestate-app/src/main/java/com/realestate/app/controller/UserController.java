package com.realestate.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.realestate.app.model.User;
import com.realestate.app.service.AgentService;
import com.realestate.app.service.UserService;
import com.realestate.app.validation.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private AgentService agentService;
    
    @Autowired
    private UserValidator userValidator;

    // Visualizza tutti gli utenti (accesso ADMIN)
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/users";
    }

    // Visualizza i dettagli di un utente (accesso ADMIN)
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showUserDetails(@PathVariable("id") Long id, Model model) {
        userService.findById(id).ifPresent(user -> model.addAttribute("user", user));
        return "admin/user-details";
    }

    // Mostra il form per modificare un utente (accesso ADMIN)
    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditUserForm(@PathVariable("id") Long id, Model model) {
        userService.findById(id).ifPresent(user -> {
            model.addAttribute("user", user);
            model.addAttribute("agents", agentService.findAll());
        });
        return "admin/edit-user";
    }

    // Aggiorna un utente (accesso ADMIN)
    @PostMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateUser(@PathVariable("id") Long id,
                            @Valid @ModelAttribute("user") User user,
                            BindingResult bindingResult,
                            @RequestParam("image") MultipartFile image,
                            Model model) {
        
        user.setId(id);
        userValidator.validate(user, bindingResult);
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("agents", agentService.findAll());
            return "admin/edit-user";
        }
        
        // Gestione del caricamento dell'immagine
        if (!image.isEmpty()) {
            // Logica per salvare l'immagine e impostare l'URL
            // user.setImageUrl(savedImageUrl);
        }
        
        userService.update(user);
        return "redirect:/user/all";
    }

    // Elimina un utente (accesso ADMIN)
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/user/all";
    }

    // Visualizza il profilo dell'utente corrente (accesso ADMIN e AGENT)
    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public String showUserProfile(Model model) {
        // In un'applicazione reale, qui si recupererebbe l'utente autenticato
        // User currentUser = getCurrentAuthenticatedUser();
        // model.addAttribute("user", currentUser);
        return "user/profile";
    }

    // Mostra il form per modificare il profilo dell'utente corrente (accesso ADMIN e AGENT)
    @GetMapping("/profile/edit")
    @PreAuthorize("isAuthenticated()")
    public String showEditProfileForm(Model model) {
        // In un'applicazione reale, qui si recupererebbe l'utente autenticato
        // User currentUser = getCurrentAuthenticatedUser();
        // model.addAttribute("user", currentUser);
        return "user/edit-profile";
    }

    // Aggiorna il profilo dell'utente corrente (accesso ADMIN e AGENT)
    @PostMapping("/profile/edit")
    @PreAuthorize("isAuthenticated()")
    public String updateProfile(@Valid @ModelAttribute("user") User user,
                               BindingResult bindingResult,
                               @RequestParam("image") MultipartFile image) {
        
        userValidator.validate(user, bindingResult);
        
        if (bindingResult.hasErrors()) {
            return "user/edit-profile";
        }
        
        // Gestione del caricamento dell'immagine
        if (!image.isEmpty()) {
            // Logica per salvare l'immagine e impostare l'URL
            // user.setImageUrl(savedImageUrl);
        }
        
        userService.update(user);
        return "redirect:/user/profile";
    }
}
