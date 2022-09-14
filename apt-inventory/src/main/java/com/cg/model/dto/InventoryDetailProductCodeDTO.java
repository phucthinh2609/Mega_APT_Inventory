package com.cg.model.dto;


import com.cg.model.InventoryDetail;
import com.cg.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InventoryDetailProductCodeDTO {

    private String id;

    private LocalDate stockInDate;

    private String productCode;

    private BigDecimal stockInPrice;

    private BigDecimal purchaseOrderPrice;

    private boolean selled;

    private BigDecimal grossProfit;

    private ProductDTO product;

    public InventoryDetailProductCodeDTO(String id, LocalDate stockInDate, String productCode, BigDecimal stockInPrice, BigDecimal purchaseOrderPrice, boolean selled, BigDecimal grossProfit, Product product) {
        this.id = id;
        this.stockInDate = stockInDate;
        this.productCode = productCode;
        this.stockInPrice = stockInPrice;
        this.purchaseOrderPrice = purchaseOrderPrice;
        this.selled = selled;
        this.grossProfit = grossProfit;
        this.product = product.toProductDTO();
    }

    public InventoryDetail toInventoryDetail(){
        return new InventoryDetail()
                .setId(id)
                .setStockInDate(stockInDate)
                .setProductCode(productCode)
                .setStockInPrice(stockInPrice)
                .setPurchaseOrderPrice(purchaseOrderPrice)
                .setSelled(selled)
                .setGrossProfit(grossProfit)
                .setProduct(product.toProduct());
    }
}
