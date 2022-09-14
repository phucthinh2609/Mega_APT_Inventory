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
    private Long totalOrder;
    private Long totalSales;
    private BigDecimal revenue;
    private BigDecimal grossProfit;

    public Statistics(String id) {
        this.id = id;
    }

    public Statistics(Long totalOrder, Long totalSales, BigDecimal revenue) {
        this.totalOrder = totalOrder;
        this.totalSales = totalSales;
        this.revenue = revenue;
    }

}


