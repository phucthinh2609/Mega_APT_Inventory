package com.cg.model;

import com.cg.model.dto.InventoryDetailProductCodeDTO;
import com.cg.model.enums.EInventoryDetailStatus;
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
import java.time.LocalDateTime;

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
    private LocalDateTime stockInDate;

    @Column(name = "sell_by_date")
    private LocalDateTime sellByDate;

    @Column(name = "product_code", unique = true)
    private String productCode;

    @Column(name = "stock_in_price")
    @Digits(integer = 12, fraction = 0)
    private BigDecimal stockInPrice;

    @Column(name = "sale_price")
    @Digits(integer = 12, fraction = 0)
    private BigDecimal salePrice;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255) default 'IN_STOCK'")
    private EInventoryDetailStatus status;

    @Column(name = "gross_profit")
    @Digits(integer = 12, fraction = 0)
    private BigDecimal grossProfit;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public InventoryDetailProductCodeDTO toInventoryDetailProductCodeDTO() {
        return new InventoryDetailProductCodeDTO()
                .setId(id)
                .setStockInDate(stockInDate)
                .setProductCode(productCode)
                .setStockInPrice(stockInPrice)
                .setSalePrice(salePrice)
                .setStatus(status)
                .setGrossProfit(grossProfit)
                .setProduct(product.toProductDTO());
    }
}
