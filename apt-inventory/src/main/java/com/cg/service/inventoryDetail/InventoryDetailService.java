package com.cg.service.inventoryDetail;

import com.cg.model.InventoryDetail;
import com.cg.model.dto.InventoryDetailDTO;
import com.cg.service.IGeneralService;

import java.util.List;

public interface InventoryDetailService extends IGeneralService<InventoryDetail> {
    List<InventoryDetailDTO> getAllInventoryDetails();

    List<InventoryDetailDTO> getInventoryGroupByProduct();
}
