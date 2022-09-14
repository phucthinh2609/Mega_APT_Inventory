package com.cg.model.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Statistics {
    private int totalOrder;
    private int totalSales;
    private BigDecimal revenue;
    private BigDecimal grossProfit;

}


