package com.cg.model.dto;


import com.cg.model.Order;
import com.cg.model.OrderDetail;
import com.cg.model.Product;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderDetailDTO implements Validator {

    private String id;

    private String  price;

    private String productCode;

    private ProductDTO product;

    private OrderDTO order;


    public OrderDetailDTO(String id, String productCode, BigDecimal price, Product product, Order order) {
        this.id = id;
        this.productCode = productCode;
        this.price = price.toString();
        this.product = product.toProductDTO();
        this.order = order.toOrderDTO();
        this.productCode = productCode;
    }

    public OrderDetail toOrderDetail() {
        return new OrderDetail()
                .setId(id)
                .setProductCode(productCode)
                .setPrice(new BigDecimal(price))
                .setProduct(product.toProduct())
                .setOrder(order.toOrder());
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
