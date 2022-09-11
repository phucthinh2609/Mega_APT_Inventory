package com.cg.model.dto;

import com.cg.model.enums.EPurchaseOrderStatus;
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
    private EPurchaseOrderStatus eStatus;
    private String statusValue;

    public PurchaseOrderDTO(String purchaseOrderId, LocalDate stockInDate, String supplierName, int quantity, BigDecimal amount, String employeeCode, EPurchaseOrderStatus eStatus) {
        this.purchaseOrderId = purchaseOrderId;
        this.stockInDate = stockInDate;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.amount = amount;
        this.employeeCode = employeeCode;
        this.eStatus = eStatus;
        this.statusValue = eStatus.getValue();
    }
}
