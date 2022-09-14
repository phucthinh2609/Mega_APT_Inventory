package com.cg.service.inventory;

import com.cg.model.dto.InventoryDTO;
import com.cg.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<InventoryDTO> getInventoryOverView() {
        return inventoryRepository.getInventoryOverView();
    }

    @Override
    public Optional<InventoryDTO> getInventoryByProductId(String productId) {
        return inventoryRepository.getInventoryByProductId(productId);
    }
}
