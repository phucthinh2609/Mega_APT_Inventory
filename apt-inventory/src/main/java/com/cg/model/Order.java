package com.cg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Digits(integer = 15, fraction = 0)
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "quantity_total")
    private int quantityTotal;

    @ManyToOne
    @JoinColumn(name = "location_delivery_id", nullable = false)
    private LocationDelivery locationDelivery;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(targetEntity = OrderDetail.class, mappedBy = "order", fetch = FetchType.EAGER)
    private Set<OrderDetail> orderDetails;
}
