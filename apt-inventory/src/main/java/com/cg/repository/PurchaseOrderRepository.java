package com.cg.repository;

import com.cg.model.PurchaseOrder;
import com.cg.model.dto.PurchaseOrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrderRepository  extends JpaRepository<PurchaseOrder, String> {
    @Query("SELECT new com.cg.model.dto.PurchaseOrderDTO (" +
                "p.id, " +
                "p.stockInDate, " +
                "s.companyName, " +
                "p.totalQuantity, " +
                "p.totalAmount, " +
                "e.id, " +
                "p.status " +
            ") " +
            "FROM PurchaseOrder AS p, Employee AS e, Supplier AS s " +
            "WHERE p.employee.id = e.id " +
            "AND p.supplier.id = s.id " +
            "ORDER BY p.stockInDate "
    )
    List<PurchaseOrderDTO> getAllPurchaseOrderDTO();
}
