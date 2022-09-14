package com.cg.service.inventoryDetail;

import com.cg.model.InventoryDetail;
import com.cg.model.dto.InventoryDetailDTO;

import java.math.BigDecimal;
import java.util.List;

public interface InventoryDetailService {
    List<InventoryDetailDTO> getProductDetail(String productId);
    int getInventoryTotalQuantity();

    BigDecimal getInventoryTotalAmount();
//    int getQuantityOfGroup(String group);
//    List<InventoryDetailDTO> getInventoryGroupByBrand();
//    List<InventoryDetailDTO> getInventoryGroupByModel();
//    List<InventoryDetailDTO> getInventoryGroupByCore(String core);
//    List<InventoryDetailDTO> getInventoryGroupByRam();
//    List<InventoryDetailDTO> getInventoryGroupByCapacity();
    List<InventoryDetailDTO> getAllInventoryDetails();
}
