package com.cg.model.dto;

import com.cg.model.Inventory;
import com.cg.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class InventoryDTO {

    private String productId;

    private String productTitle;

    private int available;

    private String id;

    private ProductDTO product;

    public InventoryDTO(String productId, String productTitle, int available) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.available = available;
    }

    public InventoryDTO(String id, int available, Product product) {
        this.id = id;
        this.available = available;
        this.product = product.toProductDTO();
    }

    public Inventory toInventory() {
        return new Inventory()
                .setId(id)
                .setProduct(product.toProduct())
                .setAvailable(available);
    }
}
