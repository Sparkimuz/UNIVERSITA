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

import com.realestate.app.model.Property;
import com.realestate.app.service.PropertyService;
import com.realestate.app.validation.PropertyValidator;

@Controller
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;
    
    @Autowired
    private PropertyValidator propertyValidator;

    // Visualizza tutte le proprietà (accesso pubblico)
    @GetMapping("/all")
    public String showAllProperties(Model model) {
        List<Property> properties = propertyService.findAll();
        model.addAttribute("properties", properties);
        return "public/properties";
    }

    // Visualizza i dettagli di una proprietà (accesso pubblico)
    @GetMapping("/{id}")
    public String showPropertyDetails(@PathVariable("id") Long id, Model model) {
        Optional<Property> property = propertyService.findById(id);
        if (property.isPresent()) {
            model.addAttribute("property", property.get());
            return "public/property-details";
        }
        return "redirect:/property/all";
    }

    // Ricerca proprietà per città (accesso pubblico)
    @GetMapping("/search")
    public String searchPropertiesByCity(@RequestParam("city") String city, Model model) {
        List<Property> properties = propertyService.findByCity(city);
        model.addAttribute("properties", properties);
        model.addAttribute("city", city);
        return "public/properties";
    }

    // Mostra il form per aggiungere una nuova proprietà (accesso ADMIN e AGENT)
    @GetMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT')")
    public String showAddPropertyForm(Model model) {
        model.addAttribute("property", new Property());
        return "property/add-property";
    }

    // Salva una nuova proprietà (accesso ADMIN e AGENT)
    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT')")
    public String addProperty(@Valid @ModelAttribute("property") Property property, 
                             BindingResult bindingResult,
                             @RequestParam("image") MultipartFile image,
                             Model model) {
        
        propertyValidator.validate(property, bindingResult);
        
        if (bindingResult.hasErrors()) {
            return "property/add-property";
        }
        
        // Gestione del caricamento dell'immagine
        if (!image.isEmpty()) {
            // Logica per salvare l'immagine e impostare l'URL
            // property.setImageUrl(savedImageUrl);
        }
        
        propertyService.save(property);
        return "redirect:/property/all";
    }

    // Mostra il form per modificare una proprietà (accesso ADMIN e AGENT)
    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT')")
    public String showEditPropertyForm(@PathVariable("id") Long id, Model model) {
        Optional<Property> property = propertyService.findById(id);
        if (property.isPresent()) {
            model.addAttribute("property", property.get());
            return "property/edit-property";
        }
        return "redirect:/property/all";
    }

    // Aggiorna una proprietà (accesso ADMIN e AGENT)
    @PostMapping("/edit/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT')")
    public String updateProperty(@PathVariable("id") Long id,
                                @Valid @ModelAttribute("property") Property property,
                                BindingResult bindingResult,
                                @RequestParam("image") MultipartFile image,
                                Model model) {
        
        property.setId(id);
        propertyValidator.validate(property, bindingResult);
        
        if (bindingResult.hasErrors()) {
            return "property/edit-property";
        }
        
        // Gestione del caricamento dell'immagine
        if (!image.isEmpty()) {
            // Logica per salvare l'immagine e impostare l'URL
            // property.setImageUrl(savedImageUrl);
        }
        
        propertyService.update(property);
        return "redirect:/property/all";
    }

    // Elimina una proprietà (accesso ADMIN e AGENT)
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT')")
    public String deleteProperty(@PathVariable("id") Long id) {
        propertyService.deleteById(id);
        return "redirect:/property/all";
    }
}
