package com.cg.repository;

import com.cg.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findProductBySlug(String slug);
}
