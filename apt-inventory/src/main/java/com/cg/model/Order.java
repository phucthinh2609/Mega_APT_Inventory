package com.cg.model;

import com.cg.model.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Accessors(chain = true)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "export_date")
    private LocalDateTime exportDate;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @Digits(integer = 15, fraction = 0)
    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "quantity_total")
    private int quantityTotal;

    @OneToOne
    @JoinColumn(name = "delivery_info_id")
    private DeliveryInfo deliveryInfo;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(targetEntity = OrderDetail.class, mappedBy = "order", fetch = FetchType.EAGER)
    private Set<OrderDetail> orderDetails;

    public OrderDTO toOrderDTO() {
        return new OrderDTO()
                .setId(id)
                .setQuantityTotal(String.valueOf(quantityTotal))
                .setTotalAmount(totalAmount.toString())
                .setDeliveryInfoDTO(deliveryInfo.toDeliveryInfoDTO())
                .setCustomer(customer.toCustomerDTO())
                .setDeliveryDate(deliveryDate)
                .setExportDate(exportDate)
                .setOrderDate(orderDate);
    }
}
