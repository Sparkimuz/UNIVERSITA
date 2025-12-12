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

import com.realestate.app.model.RealEstateAgency;
import com.realestate.app.service.RealEstateAgencyService;
import com.realestate.app.validation.RealEstateAgencyValidator;

@Controller
@RequestMapping("/agency")
public class RealEstateAgencyController {

    @Autowired
    private RealEstateAgencyService agencyService;
    
    @Autowired
    private RealEstateAgencyValidator agencyValidator;

    // Visualizza tutte le agenzie (accesso pubblico)
    @GetMapping("/all")
    public String showAllAgencies(Model model) {
        List<RealEstateAgency> agencies = agencyService.findAll();
        model.addAttribute("agencies", agencies);
        return "public/agencies";
    }

    // Visualizza i dettagli di un'agenzia (accesso pubblico)
    @GetMapping("/{id}")
    public String showAgencyDetails(@PathVariable("id") Long id, Model model) {
        Optional<RealEstateAgency> agency = agencyService.findById(id);
        if (agency.isPresent()) {
            model.addAttribute("agency", agency.get());
            return "public/agency-details";
        }
        return "redirect:/agency/all";
    }

    // Mostra il form per aggiungere una nuova agenzia (accesso ADMIN)
    @GetMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String showAddAgencyForm(Model model) {
        model.addAttribute("agency", new RealEstateAgency());
        return "admin/add-agency";
    }

    // Salva una nuova agenzia (accesso ADMIN)
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String addAgency(@Valid @ModelAttribute("agency") RealEstateAgency agency, 
                           BindingResult bindingResult) {
        
        agencyValidator.validate(agency, bindingResult);
        
        if (bindingResult.hasErrors()) {
            return "admin/add-agency";
        }
        
        agencyService.save(agency);
        return "redirect:/agency/all";
    }

    // Mostra il form per modificare un'agenzia (accesso ADMIN)
    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditAgencyForm(@PathVariable("id") Long id, Model model) {
        Optional<RealEstateAgency> agency = agencyService.findById(id);
        if (agency.isPresent()) {
            model.addAttribute("agency", agency.get());
            return "admin/edit-agency";
        }
        return "redirect:/agency/all";
    }

    // Aggiorna un'agenzia (accesso ADMIN)
    @PostMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateAgency(@PathVariable("id") Long id,
                              @Valid @ModelAttribute("agency") RealEstateAgency agency,
                              BindingResult bindingResult) {
        
        agency.setId(id);
        agencyValidator.validate(agency, bindingResult);
        
        if (bindingResult.hasErrors()) {
            return "admin/edit-agency";
        }
        
        agencyService.update(agency);
        return "redirect:/agency/all";
    }

    // Elimina un'agenzia (accesso ADMIN)
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteAgency(@PathVariable("id") Long id) {
        agencyService.deleteById(id);
        return "redirect:/agency/all";
    }
}
