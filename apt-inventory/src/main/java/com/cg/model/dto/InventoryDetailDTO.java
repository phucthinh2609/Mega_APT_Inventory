package com.cg.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

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
    private LocalDate stockInDate;
    private boolean selled;
    private BigDecimal grossProfit;
    private Long quantity;

    public InventoryDetailDTO(String id, String title, String productCode, BigDecimal stockInPrice, LocalDate stockInDate) {
        this.id = id;
        this.title = title;
        this.productCode = productCode;
        this.stockInPrice = stockInPrice;
        this.stockInDate = stockInDate;
    }

    public InventoryDetailDTO(LocalDate stockInDate, String title, BigDecimal stockInPrice, Long quantity) {
        this.stockInDate = stockInDate;
        this.title = title;
        this.stockInPrice = stockInPrice;
        this.quantity = quantity;
    }

    public InventoryDetailDTO(String title, Long quantity) {
        this.title = title;
        this.quantity = quantity;
    }

    public InventoryDetailDTO(Long quantity) {
        this.quantity = quantity;
    }
}
