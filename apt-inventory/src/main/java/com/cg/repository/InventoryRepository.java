package com.cg.repository;

import com.cg.model.Inventory;
import com.cg.model.OrderDetail;
import com.cg.model.dto.InventoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository  extends JpaRepository<Inventory, String> {
    @Query("SELECT new com.cg.model.dto.InventoryDTO (" +
            "p.id, " +
            "p.title, " +
            "inv.available " +
            ") " +
            "FROM Inventory AS inv, Product AS p " +
            "WHERE inv.product.id = p.id "

    )
    List<InventoryDTO> getInventoryOverView();

    @Query("SELECT new com.cg.model.dto.InventoryDTO (" +
            "inv.id," +
            "inv.available," +
            "inv.product" +
            ") " +
            "FROM Inventory AS inv " +
            "WHERE inv.product.id = :productId"
    )
    Optional<InventoryDTO> getInventoryByProductId(String productId);

}
