package com.cg.model.dto;

import com.cg.model.Customer;
import com.cg.model.LocationDelivery;
import com.cg.model.Order;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

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
    private LocationDeliveryDTO locationRegionDelivery;

    public OrderDTO(String id, int quantityTotal, BigDecimal totalAmount, Customer customer, LocationDelivery locationRegionDelivery) {
        this.id = id;
        this.quantityTotal = String.valueOf(quantityTotal);
        this.totalAmount = totalAmount.toString();
        this.customer = customer.toCustomerDTO();
        this.locationRegionDelivery = locationRegionDelivery.toLocationDeliveryDTO();
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
