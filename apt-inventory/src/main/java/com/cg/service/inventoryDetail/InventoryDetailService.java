package com.cg.service.inventoryDetail;

import com.cg.model.dto.InventoryDetailDTO;
import com.cg.model.dto.Statistics;
import com.cg.model.dto.InventoryDetailProductCodeDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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

    Optional<Statistics> getStatisticsByTime(String startTime);

    Optional<InventoryDetailProductCodeDTO> getInventoryDetailByProductCode(String productCode);
}
