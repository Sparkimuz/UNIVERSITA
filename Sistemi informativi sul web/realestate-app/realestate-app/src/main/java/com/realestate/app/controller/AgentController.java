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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.realestate.app.model.Agent;
import com.realestate.app.model.RealEstateAgency;
import com.realestate.app.service.AgentService;
import com.realestate.app.service.RealEstateAgencyService;
import com.realestate.app.validation.AgentValidator;

@Controller
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    private AgentService agentService;
    
    @Autowired
    private RealEstateAgencyService agencyService;
    
    @Autowired
    private AgentValidator agentValidator;

    // Visualizza tutti gli agenti (accesso pubblico)
    @GetMapping("/all")
    public String showAllAgents(Model model) {
        List<Agent> agents = agentService.findAll();
        model.addAttribute("agents", agents);
        return "public/agents";
    }

    // Visualizza i dettagli di un agente (accesso pubblico)
    @GetMapping("/{id}")
    public String showAgentDetails(@PathVariable("id") Long id, Model model) {
        Optional<Agent> agent = agentService.findById(id);
        if (agent.isPresent()) {
            model.addAttribute("agent", agent.get());
            return "public/agent-details";
        }
        return "redirect:/agent/all";
    }

    // Mostra il form per aggiungere un nuovo agente (accesso ADMIN)
    @GetMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String showAddAgentForm(Model model) {
        model.addAttribute("agent", new Agent());
        model.addAttribute("agencies", agencyService.findAll());
        return "admin/add-agent";
    }

    // Salva un nuovo agente (accesso ADMIN)
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String addAgent(@Valid @ModelAttribute("agent") Agent agent, 
                          BindingResult bindingResult,
                          @RequestParam("agency") Long agencyId,
                          @RequestParam("image") MultipartFile image,
                          Model model) {
        
        agentValidator.validate(agent, bindingResult);
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("agencies", agencyService.findAll());
            return "admin/add-agent";
        }
        
        // Imposta l'agenzia
        Optional<RealEstateAgency> agency = agencyService.findById(agencyId);
        if (agency.isPresent()) {
            agent.setAgency(agency.get());
        }
        
        // Gestione del caricamento dell'immagine
        if (!image.isEmpty()) {
            // Logica per salvare l'immagine e impostare l'URL
            // agent.setImageUrl(savedImageUrl);
        }
        
        agentService.save(agent);
        return "redirect:/agent/all";
    }

    // Mostra il form per modificare un agente (accesso ADMIN)
    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditAgentForm(@PathVariable("id") Long id, Model model) {
        Optional<Agent> agent = agentService.findById(id);
        if (agent.isPresent()) {
            model.addAttribute("agent", agent.get());
            model.addAttribute("agencies", agencyService.findAll());
            return "admin/edit-agent";
        }
        return "redirect:/agent/all";
    }

    // Aggiorna un agente (accesso ADMIN)
    @PostMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateAgent(@PathVariable("id") Long id,
                             @Valid @ModelAttribute("agent") Agent agent,
                             BindingResult bindingResult,
                             @RequestParam("agency") Long agencyId,
                             @RequestParam("image") MultipartFile image,
                             Model model) {
        
        agent.setId(id);
        agentValidator.validate(agent, bindingResult);
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("agencies", agencyService.findAll());
            return "admin/edit-agent";
        }
        
        // Imposta l'agenzia
        Optional<RealEstateAgency> agency = agencyService.findById(agencyId);
        if (agency.isPresent()) {
            agent.setAgency(agency.get());
        }
        
        // Gestione del caricamento dell'immagine
        if (!image.isEmpty()) {
            // Logica per salvare l'immagine e impostare l'URL
            // agent.setImageUrl(savedImageUrl);
        }
        
        agentService.update(agent);
        return "redirect:/agent/all";
    }

    // Elimina un agente (accesso ADMIN)
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteAgent(@PathVariable("id") Long id) {
        agentService.deleteById(id);
        return "redirect:/agent/all";
    }
}
