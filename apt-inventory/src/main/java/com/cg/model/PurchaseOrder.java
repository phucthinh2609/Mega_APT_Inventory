package com.cg.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Entity
@Table(name = "purchase_orders")
public class PurchaseOrder {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Digits(integer = 15, fraction = 0)
    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "quantity_total", nullable = false)
    private int quantityTotal;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
