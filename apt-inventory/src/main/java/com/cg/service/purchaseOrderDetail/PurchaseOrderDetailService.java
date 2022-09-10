package com.cg.service.purchaseOrderDetail;

import com.cg.model.PurchaseOrdersDetail;

import java.util.Optional;

public interface PurchaseOrderDetailService {
//    Optional<PurchaseOrdersDetailDTO> findByPurchaseOrderId(String id);
    Optional<PurchaseOrdersDetail> findByPurchaseOrderId(String purchaseOrderId);
}
