package com.cg.controller.api;


import com.cg.exception.DataInputException;
import com.cg.model.ComputerConfigurationParameter;
import com.cg.model.Product;
import com.cg.model.ProductMedia;
import com.cg.model.dto.ProductDTO;
import com.cg.model.dto.ProductRender;
import com.cg.service.computerConfigurationParameter.ComputerConfigurationParameterService;
import com.cg.service.product.ProductService;
import com.cg.service.productMedia.ProductMediaService;
import com.cg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/products")
public class ProductAPI {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMediaService productMediaService;

    @Autowired
    private ComputerConfigurationParameterService computerConfigurationParameterService;

    @Autowired
    private AppUtils appUtils;

    @GetMapping
    public ResponseEntity<Iterable<?>> findAll() {
        try {
            Iterable<ProductMedia> productMediaList = productMediaService.findAllByOrderByProductIdAsc();
            if (productMediaList == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            HashSet<ProductRender> productRenderList = convertToProductRender(productMediaList);
            return new ResponseEntity<>(productRenderList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{slug}")
    public ResponseEntity<?> findBySlug(@PathVariable String slug){
        Optional<Product> currentProduct = productService.findProductBySlug(slug);

        if (!currentProduct.isPresent()) {
            throw new DataInputException("Product is not found");
        }

        Iterable<ProductMedia> productMediaList = productMediaService.findAllByProductId(currentProduct.get().getId());

        if (productMediaList == null) {
            throw new DataInputException("Product is not found");
        }

        HashSet<ProductRender> productRenderList = convertToProductRender(productMediaList);
        return new ResponseEntity<>(productRenderList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Validated ProductDTO productDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return appUtils.mapErrorToResponse(bindingResult);

        try {
            Product createdProduct = productService.create(productDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            throw new DataInputException(e.getMessage());
        }
    }
//
//    @PutMapping("/edit/{mediaId}")
//    public ResponseEntity<?> editMedia(@PathVariable String mediaId) {
//
//        if (bindingResult.hasErrors())
//            return appUtils.mapErrorToResponse(bindingResult);
//
//        try {
//            Product createdProduct = productService.create(productDTO);
//
////            IProductDTO iProductDTO =  productService.findIProductDTOById(createdProduct.getId());
//
//            return new ResponseEntity<>(HttpStatus.CREATED);
//
//        } catch (DataIntegrityViolationException e) {
//            throw new DataInputException("Product creation information is not valid, please check the information again");
//        }
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) throws IOException {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            productService.delete(product.get());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            throw new DataInputException("Invalid product information");
        }
    }

    private HashSet<ProductRender> convertToProductRender(Iterable<ProductMedia> productMediaList) {
        String tempId = "";
        HashMap<String, String> fileUrls = new HashMap<>();
        ProductRender productRender = new ProductRender();
        HashSet<ProductRender> productRenderList = new HashSet<>();
        List<ComputerConfigurationParameter> computerConfigurationParameters = computerConfigurationParameterService.findAll();

        for (ProductMedia productMedia : productMediaList) {
            if (tempId.equals(productMedia.getProduct().getId())) {
                fileUrls.put(productMedia.getId(), productMedia.getFileUrl());
            } else {
                productRender = new ProductRender();
                fileUrls = new HashMap<>();
                productRender.setId(productMedia.getProduct().getId());
                productRender.setBrand(productMedia.getProduct().getBrand());
                productRender.setModel(productMedia.getProduct().getModel());
                productRender.setTitle(productMedia.getProduct().getTitle());
                productRender.setSlug(productMedia.getProduct().getSlug());
                productRender.setPurchaseOrderPrice(productMedia.getProduct().getPurchaseOrderPrice());
                productRender.setDescription(productMedia.getProduct().getDescription());
                productRender.setComputerConfigurationParameters(computerConfigurationParameters);
                productRender.setBusinessStatus(productMedia.getProduct().getBusinessStatus().getValue());
//                productRender.setBlogId(productMedia.getProduct().getBlog().getId());
                fileUrls.put(productMedia.getId(), productMedia.getFileUrl());
            }
            productRender.setFileUrls(fileUrls);

            productRenderList.add(productRender);
            tempId = productMedia.getProduct().getId();
        }
        return productRenderList;
    }
}