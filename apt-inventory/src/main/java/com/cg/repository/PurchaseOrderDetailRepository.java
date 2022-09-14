package com.cg.repository;

import com.cg.model.PurchaseOrdersDetail;
import com.cg.model.dto.PurchaseOrderDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrderDetailRepository extends JpaRepository<PurchaseOrdersDetail, String> {

    @Query("SELECT new com.cg.model.dto.PurchaseOrderDetailDTO (" +
            "ord.stockInDate, " +
            "ordDe.product.title, " +
            "ordDe.price, " +
            "ordDe.quantity, " +
            "ordDe.amount " +
            ") " +
            "FROM PurchaseOrdersDetail AS ordDe, PurchaseOrder AS ord " +
            "WHERE ordDe.purchaseOrder.id = ord.id " +
            "AND ord.id = ?1"
    )
    List<PurchaseOrderDetailDTO> getPurchaseOrderDetails(String purchaseOrderId);
}
