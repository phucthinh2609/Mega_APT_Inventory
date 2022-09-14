package com.cg.model.dto;


import com.cg.model.InventoryDetail;
import com.cg.model.Product;
import com.cg.model.enums.EInventoryDetailStatus;
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

    private BigDecimal salePrice;

    private EInventoryDetailStatus status;

    private BigDecimal grossProfit;

    private ProductDTO product;

    public InventoryDetailProductCodeDTO(String id, LocalDate stockInDate, String productCode, BigDecimal stockInPrice, BigDecimal salePrice, EInventoryDetailStatus status, BigDecimal grossProfit, Product product) {
        this.id = id;
        this.stockInDate = stockInDate;
        this.productCode = productCode;
        this.stockInPrice = stockInPrice;
        this.salePrice = salePrice;
        this.status = status;
        this.grossProfit = grossProfit;
        this.product = product.toProductDTO();
    }

    public InventoryDetail toInventoryDetail(){
        return new InventoryDetail()
                .setId(id)
                .setStockInDate(stockInDate)
                .setProductCode(productCode)
                .setStockInPrice(stockInPrice)
                .setSalePrice(salePrice)
                .setStatus(status)
                .setGrossProfit(grossProfit)
                .setProduct(product.toProduct());
    }
}
