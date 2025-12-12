package com.example.catalog.web;

import com.example.catalog.model.Comment;
import com.example.catalog.model.Product;
import com.example.catalog.repo.CommentRepository;
import com.example.catalog.repo.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/comments")
public class CommentController {

  private final CommentRepository comments;
  private final ProductRepository products;

  public CommentController(CommentRepository comments, ProductRepository products) {
    this.comments = comments;
    this.products = products;
  }

  @PostMapping("/product/{productId}")
  public String create(@PathVariable("productId") Long productId,
                       @ModelAttribute Comment form,
                       Authentication auth,
                       RedirectAttributes ra) {
    Product p = products.findById(productId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    Comment c = new Comment();
    c.setProduct(p);
    c.setText(form.getText());
    c.setAuthorUsername(auth != null ? auth.getName() : "anon");
    c.setCreatedAt(LocalDateTime.now());
    comments.save(c);
    ra.addFlashAttribute("message", "Commento pubblicato");
    return "redirect:/products/" + productId;
  }

  @GetMapping("/{id}/edit")
  public String editForm(@PathVariable("id") Long id,
                         Authentication auth,
                         Model model) {
    Comment c = comments.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    if (!canManage(auth, c)) throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    model.addAttribute("comment", c);
    model.addAttribute("productId", c.getProduct().getId());
    return "comments/edit";
  }

  @PostMapping("/{id}/update")
  public String update(@PathVariable("id") Long id,
                       @ModelAttribute Comment form,
                       Authentication auth,
                       RedirectAttributes ra) {
    Comment c = comments.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    if (!canManage(auth, c)) throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    c.setText(form.getText());
    comments.save(c);
    ra.addFlashAttribute("message", "Commento aggiornato");
    return "redirect:/products/" + c.getProduct().getId();
  }

  @PostMapping("/{id}/delete")
  public String delete(@PathVariable("id") Long id,
                       Authentication auth,
                       RedirectAttributes ra) {
    Comment c = comments.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    if (!canManage(auth, c)) throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    Long productId = c.getProduct().getId();
    comments.deleteById(id);
    ra.addFlashAttribute("message", "Commento eliminato");
    return "redirect:/products/" + productId;
  }

  private boolean canManage(Authentication auth, Comment c) {
    if (auth == null) return false;
    if (auth.getName().equals(c.getAuthorUsername())) return true;
    return auth.getAuthorities().stream().anyMatch(a -> "ROLE_ADMIN".equals(a.getAuthority()));
  }
}
