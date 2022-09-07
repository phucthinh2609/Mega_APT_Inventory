package com.cg.model.dto;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InventoryDetailDTO {
    private String id;
    private String title;
    private String productCode;
    private BigDecimal purchaseOrderPrice;
    private BigDecimal stockInPrice;
    private boolean selled;
    private BigDecimal grossProfit;
    private Long quantity;

    public InventoryDetailDTO(String id, String title, String productCode, BigDecimal stockInPrice) {
        this.id = id;
        this.title = title;
        this.productCode = productCode;
        this.stockInPrice = stockInPrice;
    }

    public InventoryDetailDTO(String title, Long quantity) {
        this.title = title;
        this.quantity = quantity;
    }
}
