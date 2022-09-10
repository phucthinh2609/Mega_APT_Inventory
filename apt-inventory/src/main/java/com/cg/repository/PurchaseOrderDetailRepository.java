package com.cg.repository;

import com.cg.model.PurchaseOrdersDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PurchaseOrderDetailRepository extends JpaRepository<PurchaseOrdersDetail, String> {

    Optional<PurchaseOrdersDetail> findByPurchaseOrderId(String purchaseOrderId);
}
