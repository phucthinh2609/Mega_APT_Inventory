package com.cg.service.productMedia;

import com.cg.model.Product;
import com.cg.model.ProductMedia;
import com.cg.model.dto.ProductMediaDTO;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface ProductMediaService {

    Iterable<ProductMedia> findAll();

    Optional<ProductMedia> findById(String id);

    Iterable<ProductMedia> findAllByProductId(String productId);

    ProductMedia create(ProductMedia productMedia);

    void delete(ProductMedia productMedia);

    Iterable<ProductMedia> findAllByOrderByProductIdAsc();

    Optional<ProductMedia> findFirstByProductId(String productId);
}
