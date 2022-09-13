package com.cg.model.dto;

import com.cg.model.Product;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderDetailDTO {
    LocalDateTime stockInDate;
    String productTitle;
    BigDecimal stockInPrice;
    int quantity;
    BigDecimal amount;


}
