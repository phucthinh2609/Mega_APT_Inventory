package com.cg.service.purchaseOrder;

import com.cg.model.PurchaseOrder;
import com.cg.model.dto.PurchaseOrderDTO;

import java.util.List;

public interface PurchaseOrderService {
    List<PurchaseOrderDTO> getAllPurchaseOrderDTO();
}
