package com.example.catalog.repo;

import com.example.catalog.model.Comment;
import com.example.catalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
  List<Comment> findByProductOrderByCreatedAtDesc(Product product);
}
