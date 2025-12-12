package com.example.catalog.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false)
  private Product product;

  @Column(nullable = false)
  private String authorUsername;

  @Column(nullable = false, length = 2000)
  private String text;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public Product getProduct() { return product; }
  public void setProduct(Product product) { this.product = product; }

  public String getAuthorUsername() { return authorUsername; }
  public void setAuthorUsername(String authorUsername) { this.authorUsername = authorUsername; }

  public String getText() { return text; }
  public void setText(String text) { this.text = text; }

  public LocalDateTime getCreatedAt() { return createdAt; }
  public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
