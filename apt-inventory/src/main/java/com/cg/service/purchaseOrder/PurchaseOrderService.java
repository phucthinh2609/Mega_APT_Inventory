package com.cg.service.purchaseOrder;

import com.cg.model.PurchaseOrder;
import com.cg.model.dto.PurchaseOrderDTO;

import java.util.List;
import java.util.Optional;

public interface PurchaseOrderService {
    Optional<PurchaseOrder> findById(String purchaseOrderId);
    List<PurchaseOrderDTO> getAllPurchaseOrderDTO();
}
