package com.cg.model;


import com.cg.model.enums.EBussinessStatus;
import com.cg.model.enums.EPurchaseOrderStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.time.LocalDate;

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

    @Column(name = "total_quantity", nullable = false)
    private int totalQuantity;

    @Column(name = "stock_in_date")
    private LocalDate stockInDate;

    @Enumerated(EnumType.STRING)
    private EPurchaseOrderStatus status;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
