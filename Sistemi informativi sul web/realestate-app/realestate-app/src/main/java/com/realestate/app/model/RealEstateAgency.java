package com.realestate.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "real_estate_agencies")
public class RealEstateAgency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "L'indirizzo è obbligatorio")
    private String address;

    @NotBlank(message = "La città è obbligatoria")
    private String city;

    @OneToMany(mappedBy = "agency")
    private List<Agent> agents = new ArrayList<>();

    // Costruttori
    public RealEstateAgency() {
    }

    public RealEstateAgency(String address, String city) {
        this.address = address;
        this.city = city;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    // Metodi di utilità
    public void addAgent(Agent agent) {
        agents.add(agent);
        agent.setAgency(this);
    }

    public void removeAgent(Agent agent) {
        agents.remove(agent);
        agent.setAgency(null);
    }

    @Override
    public String toString() {
        return "RealEstateAgency [id=" + id + ", address=" + address + ", city=" + city + "]";
    }
}
