package com.cg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "inventory_details")
public class InventoryDetail {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "stock_in_date")
    private LocalDate stockInDate;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "stock_in_price")
    @Digits(integer = 12, fraction = 0)
    private BigDecimal stockInPrice;

    @Column(name = "purchase_order_price")
    @Digits(integer = 12, fraction = 0)
    private BigDecimal purchaseOrderPrice;

    private boolean selled;

    @Column(name = "gross_profit")
    @Digits(integer = 12, fraction = 0)
    private BigDecimal grossProfit;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
