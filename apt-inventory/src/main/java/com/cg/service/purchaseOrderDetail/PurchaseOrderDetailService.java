package com.cg.service.purchaseOrderDetail;

import com.cg.model.PurchaseOrdersDetail;
import com.cg.model.dto.PurchaseOrderDetailDTO;

import java.util.List;
import java.util.Optional;

public interface PurchaseOrderDetailService {
    List<PurchaseOrderDetailDTO> getPurchaseOrderDetails(String purchaseOrderId);
}
