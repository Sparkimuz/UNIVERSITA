package com.example.catalog.web;

import com.example.catalog.model.Product;
import com.example.catalog.repo.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class CatalogController {

  private final ProductRepository products;

  public CatalogController(ProductRepository products) {
    this.products = products;
  }

  @GetMapping("/")
  public String index(Model model) {
    List<String> types = products.findAll().stream()
        .map(Product::getType)
        .filter(Objects::nonNull)
        .map(String::toLowerCase)
        .distinct()
        .sorted()
        .collect(Collectors.toList());
    model.addAttribute("types", types);
    model.addAttribute("products", products.findAllByOrderByNameAsc());
    return "index";
  }

  @GetMapping("/products")
  public String byTypeOrName(@RequestParam(name = "type", required = false) String type,
                             @RequestParam(name = "name", required = false) String name,
                             Model model) {
    List<Product> list;
    if (type != null && !type.trim().isEmpty())
      list = products.findByTypeIgnoreCaseOrderByNameAsc(type);
    else if (name != null && !name.trim().isEmpty())
      list = products.findByNameContainingIgnoreCaseOrderByNameAsc(name);
    else
      list = products.findAllByOrderByNameAsc();

    model.addAttribute("products", list);
    model.addAttribute("selectedType", type);
    model.addAttribute("searchName", name);
    return "products";
  }
}
