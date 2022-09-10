package com.cg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PurchaseOrderDTO {
    private String purchaseOrderId;
    private LocalDate stockInDate;
    private String supplierName;
    private int quantity;
    private BigDecimal amount;
    private String employeeCode;
}
