package com.realestate.app.controller;

import java.util.List;
import java.util.Optional;

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

import com.realestate.app.model.Client;
import com.realestate.app.service.ClientService;
import com.realestate.app.validation.ClientValidator;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;
    
    @Autowired
    private ClientValidator clientValidator;

    // Visualizza tutti i clienti (accesso ADMIN)
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public String showAllClients(Model model) {
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "admin/clients";
    }

    // Visualizza i dettagli di un cliente (accesso ADMIN e AGENT)
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT')")
    public String showClientDetails(@PathVariable("id") Long id, Model model) {
        Optional<Client> client = clientService.findById(id);
        if (client.isPresent()) {
            model.addAttribute("client", client.get());
            return "client/client-details";
        }
        return "redirect:/client/all";
    }

    // Mostra il form per aggiungere un nuovo cliente (accesso ADMIN e AGENT)
    @GetMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT')")
    public String showAddClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "client/add-client";
    }

    // Salva un nuovo cliente (accesso ADMIN e AGENT)
    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT')")
    public String addClient(@Valid @ModelAttribute("client") Client client, 
                           BindingResult bindingResult) {
        
        clientValidator.validate(client, bindingResult);
        
        if (bindingResult.hasErrors()) {
            return "client/add-client";
        }
        
        clientService.save(client);
        return "redirect:/client/all";
    }

    // Mostra il form per modificare un cliente (accesso ADMIN)
    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditClientForm(@PathVariable("id") Long id, Model model) {
        Optional<Client> client = clientService.findById(id);
        if (client.isPresent()) {
            model.addAttribute("client", client.get());
            return "admin/edit-client";
        }
        return "redirect:/client/all";
    }

    // Aggiorna un cliente (accesso ADMIN)
    @PostMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateClient(@PathVariable("id") Long id,
                              @Valid @ModelAttribute("client") Client client,
                              BindingResult bindingResult) {
        
        client.setId(id);
        clientValidator.validate(client, bindingResult);
        
        if (bindingResult.hasErrors()) {
            return "admin/edit-client";
        }
        
        clientService.update(client);
        return "redirect:/client/all";
    }

    // Elimina un cliente (accesso ADMIN)
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteClient(@PathVariable("id") Long id) {
        clientService.deleteById(id);
        return "redirect:/client/all";
    }
}
