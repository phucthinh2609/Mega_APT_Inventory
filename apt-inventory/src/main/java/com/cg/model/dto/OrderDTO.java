package com.cg.model.dto;

import com.cg.model.Customer;
import com.cg.model.LocationDelivery;
import com.cg.model.Order;
import com.cg.model.enums.ESituationValue;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderDTO implements Validator {

    private String id;
    private String quantityTotal;
    private String totalAmount;
    private CustomerDTO customer;
    private String customerName;
    private LocationDeliveryDTO locationRegionDelivery;

    private LocalDate orderDate;
    private LocalDate inventoryDeliveryDate;
    private LocalDate deliveryDate;
    private String description;
    private String situationValue;

    public OrderDTO(String id, int quantityTotal, BigDecimal totalAmount, Customer customer, LocationDelivery locationRegionDelivery) {
        this.id = id;
        this.quantityTotal = String.valueOf(quantityTotal);
        this.totalAmount = totalAmount.toString();
        this.customer = customer.toCustomerDTO();
        this.locationRegionDelivery = locationRegionDelivery.toLocationDeliveryDTO();
    }

    public OrderDTO(String id, String customerName, LocationDelivery locationRegionDelivery,LocalDate orderDate, LocalDate inventoryDeliveryDate, LocalDate deliveryDate, int quantityTotal, BigDecimal totalAmount, String description, ESituationValue value) {
        this.id = id;
        this.customerName = customerName;
        this.locationRegionDelivery = locationRegionDelivery.toLocationDeliveryDTO();
        this.orderDate = orderDate;
        this.inventoryDeliveryDate = inventoryDeliveryDate;
        this.deliveryDate = deliveryDate;
        this.quantityTotal = String.valueOf(quantityTotal);
        this.totalAmount = totalAmount.toString();
        this.description = description;
        this.situationValue = value.getValue();
    }

    public Order toOrder(){
        return new Order()
                .setId(id)
                .setTotalAmount(new BigDecimal(totalAmount))
                .setQuantityTotal(Integer.parseInt(quantityTotal))
                .setLocationRegionDelivery(locationRegionDelivery.toLocationDelivery())
                .setCustomer(customer.toCustomer());

    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
