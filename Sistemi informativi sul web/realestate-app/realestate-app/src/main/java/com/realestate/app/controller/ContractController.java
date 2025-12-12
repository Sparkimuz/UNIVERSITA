package com.realestate.app.controller;

import java.util.Date;
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

import com.realestate.app.model.Agent;
import com.realestate.app.model.Client;
import com.realestate.app.model.Contract;
import com.realestate.app.model.Property;
import com.realestate.app.service.AgentService;
import com.realestate.app.service.ClientService;
import com.realestate.app.service.ContractService;
import com.realestate.app.service.PropertyService;
import com.realestate.app.validation.ContractValidator;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;
    
    @Autowired
    private PropertyService propertyService;
    
    @Autowired
    private AgentService agentService;
    
    @Autowired
    private ClientService clientService;
    
    @Autowired
    private ContractValidator contractValidator;

    // Visualizza tutti i contratti (accesso ADMIN)
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public String showAllContracts(Model model) {
        List<Contract> contracts = contractService.findAll();
        model.addAttribute("contracts", contracts);
        return "admin/contracts";
    }

    // Visualizza i dettagli di un contratto (accesso ADMIN e AGENT)
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT')")
    public String showContractDetails(@PathVariable("id") Long id, Model model) {
        Optional<Contract> contract = contractService.findById(id);
        if (contract.isPresent()) {
            model.addAttribute("contract", contract.get());
            return "contract/contract-details";
        }
        return "redirect:/contract/all";
    }

    // Mostra il form per aggiungere un nuovo contratto (accesso ADMIN)
    @GetMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String showAddContractForm(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("properties", propertyService.findAll());
        model.addAttribute("agents", agentService.findAll());
        model.addAttribute("clients", clientService.findAll());
        return "admin/add-contract";
    }

    // Salva un nuovo contratto (accesso ADMIN)
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public String addContract(@Valid @ModelAttribute("contract") Contract contract, 
                             BindingResult bindingResult,
                             @RequestParam("property") Long propertyId,
                             @RequestParam("agent") Long agentId,
                             @RequestParam("client") Long clientId,
                             Model model) {
        
        contractValidator.validate(contract, bindingResult);
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("properties", propertyService.findAll());
            model.addAttribute("agents", agentService.findAll());
            model.addAttribute("clients", clientService.findAll());
            return "admin/add-contract";
        }
        
        // Imposta la proprietà
        Optional<Property> property = propertyService.findById(propertyId);
        if (property.isPresent()) {
            contract.setProperty(property.get());
        }
        
        // Imposta l'agente
        Optional<Agent> agent = agentService.findById(agentId);
        if (agent.isPresent()) {
            contract.setAgent(agent.get());
        }
        
        // Imposta il cliente
        Optional<Client> client = clientService.findById(clientId);
        if (client.isPresent()) {
            contract.setClient(client.get());
        }
        
        contractService.save(contract);
        return "redirect:/contract/all";
    }

    // Mostra i contratti per un agente specifico (accesso AGENT)
    @GetMapping("/agent")
    @PreAuthorize("hasRole('AGENT')")
    public String showAgentContracts(@RequestParam("agentId") Long agentId, Model model) {
        Optional<Agent> agent = agentService.findById(agentId);
        if (agent.isPresent()) {
            List<Contract> contracts = contractService.findByAgent(agent.get());
            model.addAttribute("contracts", contracts);
            model.addAttribute("agent", agent.get());
            return "agent/agent-contracts";
        }
        return "redirect:/";
    }

    // Mostra il form per aggiungere un nuovo contratto per un agente (accesso AGENT)
    @GetMapping("/agent/add")
    @PreAuthorize("hasRole('AGENT')")
    public String showAddAgentContractForm(@RequestParam("agentId") Long agentId, Model model) {
        Optional<Agent> agent = agentService.findById(agentId);
        if (agent.isPresent()) {
            Contract contract = new Contract();
            contract.setStartDate(new Date());
            model.addAttribute("contract", contract);
            model.addAttribute("agent", agent.get());
            model.addAttribute("properties", propertyService.findAll());
            model.addAttribute("clients", clientService.findAll());
            return "agent/add-contract";
        }
        return "redirect:/";
    }

    // Salva un nuovo contratto per un agente (accesso AGENT)
    @PostMapping("/agent/add")
    @PreAuthorize("hasRole('AGENT')")
    public String addAgentContract(@Valid @ModelAttribute("contract") Contract contract, 
                                  BindingResult bindingResult,
                                  @RequestParam("agentId") Long agentId,
                                  @RequestParam("property") Long propertyId,
                                  @RequestParam("client") Long clientId,
                                  Model model) {
        
        contractValidator.validate(contract, bindingResult);
        
        Optional<Agent> agent = agentService.findById(agentId);
        if (!agent.isPresent()) {
            return "redirect:/";
        }
        
        if (bindingResult.hasErrors()) {
            model.addAttribute("agent", agent.get());
            model.addAttribute("properties", propertyService.findAll());
            model.addAttribute("clients", clientService.findAll());
            return "agent/add-contract";
        }
        
        // Imposta l'agente
        contract.setAgent(agent.get());
        
        // Imposta la proprietà
        Optional<Property> property = propertyService.findById(propertyId);
        if (property.isPresent()) {
            contract.setProperty(property.get());
        }
        
        // Imposta il cliente
        Optional<Client> client = clientService.findById(clientId);
        if (client.isPresent()) {
            contract.setClient(client.get());
        }
        
        contractService.save(contract);
        return "redirect:/contract/agent?agentId=" + agentId;
    }

    // Elimina un contratto (accesso ADMIN)
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteContract(@PathVariable("id") Long id) {
        contractService.deleteById(id);
        return "redirect:/contract/all";
    }
}
