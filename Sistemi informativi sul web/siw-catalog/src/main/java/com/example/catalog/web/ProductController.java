package com.example.catalog.web;

import com.example.catalog.model.Comment;
import com.example.catalog.model.Product;
import com.example.catalog.repo.CommentRepository;
import com.example.catalog.repo.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@Controller
public class ProductController {

  private final ProductRepository products;
  private final CommentRepository comments;

  public ProductController(ProductRepository products, CommentRepository comments) {
    this.products = products;
    this.comments = comments;
  }

  @GetMapping("/products/{id}")
  public String detail(@PathVariable("id") Long id, Model m) {
    Product p = products.findByIdWithSimilar(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    List<Product> similar = p.getSimilarProducts() != null ? p.getSimilarProducts() : Collections.emptyList();
    List<Comment> list = comments.findByProductOrderByCreatedAtDesc(p);

    m.addAttribute("title", p.getName());
    m.addAttribute("p", p);
    m.addAttribute("similar", similar);
    m.addAttribute("comments", list != null ? list : Collections.emptyList());
    m.addAttribute("newComment", new Comment());
    return "product_detail";
  }
}
