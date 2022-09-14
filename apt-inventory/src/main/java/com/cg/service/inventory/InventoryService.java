package com.cg.service.inventory;

import com.cg.model.dto.InventoryDTO;

import java.util.List;
import java.util.Optional;

public interface InventoryService {
    List<InventoryDTO> getInventoryOverView();

    Optional<InventoryDTO> getInventoryByProductId(String productId);
}
