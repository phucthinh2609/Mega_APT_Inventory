package com.cg.service.productMedia;

import com.cg.model.Product;
import com.cg.model.ProductMedia;

import java.util.Optional;

public interface ProductMediaService {

    Iterable<ProductMedia> findAll();

    Optional<ProductMedia> findById(String id);

    Iterable<ProductMedia> findAllByProductId(String productId);

    ProductMedia create(ProductMedia productMedia);

    void delete(ProductMedia productMedia);

    Iterable<ProductMedia> findAllByOrderByProductIdAsc();
}
