package com.example.catalog.web;

import com.example.catalog.model.Product;
import com.example.catalog.repo.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/admin/products")
public class AdminProductController {

  private final ProductRepository products;

  public AdminProductController(ProductRepository products) {
    this.products = products;
  }

  @GetMapping
  public String list(Model model) {
    model.addAttribute("products", products.findAllByOrderByNameAsc());
    return "admin/products/list";
  }

  @GetMapping("/new")
  public String createForm(Model model) {
    model.addAttribute("product", new Product());
    return "admin/products/form";
  }

  @PostMapping
  public String create(@ModelAttribute Product product) {
    products.save(product);
    return "redirect:/admin/products";
  }

  @GetMapping("/{id}/edit")
  public String editForm(@PathVariable("id") Long id, Model model) {
    Product p = products.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    model.addAttribute("product", p);
    return "admin/products/form";
  }

  @PostMapping("/{id}")
  public String update(@PathVariable("id") Long id, @ModelAttribute Product form) {
    Product existing = products.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    existing.setName(form.getName());
    existing.setPrice(form.getPrice());
    existing.setDescription(form.getDescription());
    existing.setType(form.getType());
    products.save(existing);
    return "redirect:/admin/products";
  }

  @PostMapping("/{id}/delete")
  public String delete(@PathVariable("id") Long id) {
    products.deleteById(id);
    return "redirect:/admin/products";
  }

  @GetMapping("/{id}/similar")
  public String similar(@PathVariable("id") Long id, Model model) {
    Product p = products.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    List<Product> others = products.findAllByOrderByNameAsc();
    others.removeIf(o -> Objects.equals(o.getId(), p.getId()));
    model.addAttribute("p", p);
    model.addAttribute("current", p.getSimilarProducts());
    model.addAttribute("others", others);
    return "admin/products/similar";
  }

  @PostMapping("/{id}/similar/add")
  public String addSimilar(@PathVariable("id") Long id, @RequestParam("similarId") Long similarId) {
    Product p = products.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    Product s = products.findById(similarId)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    p.addSimilar(s);
    products.save(p);
    return "redirect:/admin/products/" + id + "/similar";
  }

  @PostMapping("/{id}/similar/remove")
  public String removeSimilar(@PathVariable("id") Long id, @RequestParam("similarId") Long similarId) {
    Product p = products.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    p.removeSimilarById(similarId);
    products.save(p);
    return "redirect:/admin/products/" + id + "/similar";
  }
}
