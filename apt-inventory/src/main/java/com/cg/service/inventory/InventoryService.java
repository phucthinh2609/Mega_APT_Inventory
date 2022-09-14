package com.cg.service.inventory;

import com.cg.model.dto.InventoryDTO;

import java.util.List;

public interface InventoryService {
    List<InventoryDTO> getInventoryOverView();
}
