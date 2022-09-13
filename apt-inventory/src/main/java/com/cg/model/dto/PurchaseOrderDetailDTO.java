package com.cg.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderDetailDTO {
    LocalDate stockInDate;
    String productTitle;
    BigDecimal stockInPrice;
    int quantity;
    BigDecimal amount;
}
