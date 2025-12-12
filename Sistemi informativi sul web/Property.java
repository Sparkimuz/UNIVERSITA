package com.realestate.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "L'indirizzo è obbligatorio")
    private String address;

    @NotBlank(message = "La città è obbligatoria")
    private String city;

    @NotNull(message = "Il prezzo è obbligatorio")
    @Positive(message = "Il prezzo deve essere positivo")
    private Double price;

    @NotNull(message = "La dimensione è obbligatoria")
    @Positive(message = "La dimensione deve essere positiva")
    private Double size;

    @NotBlank(message = "Il tipo è obbligatorio")
    private String type;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "property")
    private List<Contract> contracts = new ArrayList<>();

    // Costruttori
    public Property() {
    }

    public Property(String address, String city, Double price, Double size, String type) {
        this.address = address;
        this.city = city;
        this.price = price;
        this.size = size;
        this.type = type;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    // Metodi di utilità
    public void addContract(Contract contract) {
        contracts.add(contract);
        contract.setProperty(this);
    }

    public void removeContract(Contract contract) {
        contracts.remove(contract);
        contract.setProperty(null);
    }

    @Override
    public String toString() {
        return "Property [id=" + id + ", address=" + address + ", city=" + city + ", price=" + price + ", size=" + size
                + ", type=" + type + "]";
    }
}
