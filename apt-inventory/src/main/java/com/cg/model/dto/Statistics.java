package com.cg.model.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Statistics {
    private String id;
    private int totalOrder;
    private int totalSales;
    private BigDecimal revenue;
    private BigDecimal grossProfit;

    public Statistics(String id) {
        this.id = id;
    }

}


