package com.example.catalog.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Double price;

  @Column(length = 2000)
  private String description;

  private String type;

  @ManyToMany
  @JoinTable(
      name = "product_similar",
      joinColumns = @JoinColumn(name = "product_id"),
      inverseJoinColumns = @JoinColumn(name = "similar_id")
  )
  private List<Product> similarProducts = new ArrayList<>();

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public Double getPrice() { return price; }
  public void setPrice(Double price) { this.price = price; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public String getType() { return type; }
  public void setType(String type) { this.type = type; }

  public List<Product> getSimilarProducts() { return similarProducts; }
  public void setSimilarProducts(List<Product> similarProducts) {
    this.similarProducts = (similarProducts != null) ? similarProducts : new ArrayList<>();
  }

  public void addSimilar(Product p) {
    if (p == null || Objects.equals(this.id, p.getId())) return;
    boolean exists = this.similarProducts.stream().anyMatch(x -> Objects.equals(x.getId(), p.getId()));
    if (!exists) this.similarProducts.add(p);
  }

  public void removeSimilarById(Long similarId) {
    if (similarId == null) return;
    this.similarProducts.removeIf(x -> Objects.equals(x.getId(), similarId));
  }
}
