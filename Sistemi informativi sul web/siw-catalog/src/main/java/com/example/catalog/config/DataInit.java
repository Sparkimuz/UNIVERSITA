package com.example.catalog.config;

import com.example.catalog.model.Product;
import com.example.catalog.repo.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInit {

  @Bean
  CommandLineRunner init(ProductRepository products) {
    return args -> {
      if (products.count() > 0) return;

      Product l1 = p("Programmare in Java", 39.90, "Manuale completo.", "Libri");
      Product l2 = p("Spring Boot in pratica", 29.90, "Guida rapida a Spring.", "Libri");
      Product l3 = p("Design Patterns", 44.00, "Pattern classici GoF.", "Libri");

      Product g1 = p("Set Giardinaggio", 49.90, "Set base per il giardino.", "Giardino");
      Product g2 = p("Tubo Irrigazione", 19.50, "Tubo flessibile 20m.", "Giardino");
      Product g3 = p("Seme Prato", 12.90, "Miscuglio rustico.", "Giardino");

      Product c1 = p("Lampada LED", 19.99, "Lampada a risparmio energetico.", "Casa");
      Product c2 = p("Cuscino Memory", 24.90, "Cuscino ergonomico.", "Casa");
      Product c3 = p("Set Bicchieri", 14.50, "6 bicchieri vetro.", "Casa");

      // Collega simili PRIMA di salvare (così eviti LazyInitialization in bootstrap)
      l1.addSimilar(l2); l1.addSimilar(l3);
      l2.addSimilar(l1); l2.addSimilar(l3);
      g1.addSimilar(g2); g1.addSimilar(g3);
      c1.addSimilar(c2); c1.addSimilar(c3);

      products.saveAll(List.of(l1, l2, l3, g1, g2, g3, c1, c2, c3));
    };
  }

  private static Product p(String name, double price, String desc, String type) {
    Product x = new Product();
    x.setName(name);
    x.setPrice(price);
    x.setDescription(desc);
    x.setType(type);
    return x;
  }
}
