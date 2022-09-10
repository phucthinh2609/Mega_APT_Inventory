package com.cg.model.dto;

import com.cg.model.Customer;
import com.cg.model.Order;
import com.cg.model.OrderDetail;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;
import java.util.Set;

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
