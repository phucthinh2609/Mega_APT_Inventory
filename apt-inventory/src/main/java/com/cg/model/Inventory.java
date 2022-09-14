package com.cg.model;

import com.cg.model.dto.InventoryDTO;
import com.cg.model.dto.ProductDTO;
import com.cg.model.enums.EBussinessStatus;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "inventories")
public class Inventory {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private int available;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public InventoryDTO toInventoryDTO() {
        return new InventoryDTO()
                .setId(id)
                .setAvailable(available)
                .setProduct(product.toProductDTO());
    }

}
