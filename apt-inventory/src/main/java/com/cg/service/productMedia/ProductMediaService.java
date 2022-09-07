package com.cg.service.productMedia;

import com.cg.model.ProductMedia;

public interface ProductMediaService {

    Iterable<ProductMedia> findAll();

    Iterable<ProductMedia> findAllByProductId(String productId);

    ProductMedia create(ProductMedia productMedia);

    void delete(ProductMedia productMedia);

    Iterable<ProductMedia> findAllByOrderByProductIdAsc();
}
