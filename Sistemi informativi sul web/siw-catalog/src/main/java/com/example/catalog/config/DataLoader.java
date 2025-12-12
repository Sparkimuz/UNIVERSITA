package com.example.catalog.config;

import com.example.catalog.model.Product;
import com.example.catalog.repo.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Profile("!prod")
public class DataLoader implements CommandLineRunner {

  private final ProductRepository products;

  public DataLoader(ProductRepository products) {
    this.products = products;
  }

  private Product p(String name, double price, String type, String desc) {
    Product x = new Product();
    x.setName(name);
    x.setPrice(price);
    x.setType(type);         
    x.setDescription(desc);
    return x;
  }

  @Override
  @Transactional
  public void run(String... args) {
    if (products.count() > 0) return;

    List<Product> seed = new ArrayList<>();

    // Casa
    seed.add(p("Lampada LED", 19.99, "casa", "Lampada da tavolo a luce calda"));
    seed.add(p("Cuscino Memory", 24.90, "casa", "Cuscino ergonomico"));
    seed.add(p("Set Posate 24pz", 34.90, "casa", "Acciaio inox"));
    seed.add(p("Tazza Ceramica", 7.50, "casa", "Tazza 350ml"));

    // Giardino
    seed.add(p("Set Giardinaggio", 49.90, "giardino", "Pala, rastrello e cesoie"));
    seed.add(p("Tubo Irrigazione 20m", 29.90, "giardino", "Antitorsione"));
    seed.add(p("Seme Prato 1kg", 14.50, "giardino", "Miscuglio robusto"));
    seed.add(p("Vaso Terracotta 30cm", 11.90, "giardino", "Made in Italy"));

    // Libri
    seed.add(p("Libro Spring", 29.90, "libri", "Guida a Spring Boot"));
    seed.add(p("Java in pratica", 39.90, "libri", "Esempi e best practice"));
    seed.add(p("Docker Essentials", 27.50, "libri", "Container dalla A alla Z"));
    seed.add(p("SQL Cookbook", 32.00, "libri", "Ricette per query efficaci"));

    // Elettronica
    seed.add(p("Cuffie Bluetooth", 59.90, "elettronica", "Over-ear, microfono integrato"));
    seed.add(p("Mouse Wireless", 19.90, "elettronica", "2.4GHz, silenzioso"));
    seed.add(p("Tastiera Meccanica", 79.00, "elettronica", "Switch brown"));
    seed.add(p("Powerbank 20000mAh", 36.90, "elettronica", "Ricarica rapida"));

    // Cucina
    seed.add(p("Padella 28cm", 24.90, "cucina", "Rivestimento antiaderente"));
    seed.add(p("Coltello Chef", 22.90, "cucina", "Acciaio temprato"));
    seed.add(p("Bilancia Cucina", 17.50, "cucina", "Precisione 1g"));
    seed.add(p("Frullatore 600W", 39.90, "cucina", "Bicchiere 1.5L"));


    List<Product> saved = products.saveAll(seed);


    Map<String, List<Product>> byType = saved.stream()
        .collect(Collectors.groupingBy(Product::getType));


    byType.values().forEach(list -> {
      for (int i = 0; i < list.size(); i++) {
        Product a = list.get(i);
        for (int k = 1; k <= 2; k++) {
          int j = i + k;
          if (j < list.size()) {
            Product b = list.get(j);
           
            a.getSimilarProducts().add(b);
          }
        }
      }
    });

    products.saveAll(saved);
  }
}
