package com.cg.repository;

import com.cg.model.Product;
import com.cg.model.ProductMedia;
import com.cg.model.dto.OrderDTO;
import com.cg.model.dto.ProductMediaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductMediaRepository extends JpaRepository<ProductMedia, String> {
    Optional<ProductMedia> findByProduct(Product product);

    Iterable<ProductMedia> findAllByProductId(String id);

    Iterable<ProductMedia> findAllByOrderByProductIdAsc();

    Optional<ProductMedia> findFirstByProductId(String productId);
}
