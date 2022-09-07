package com.cg.service.inventoryDetail;

import com.cg.model.InventoryDetail;
import com.cg.model.dto.InventoryDetailDTO;
import com.cg.repository.InventoryDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InventoryDetailServiceImpl implements InventoryDetailService {

    @Autowired
    private InventoryDetailRepository inventoryDetailRepository;

    @Override
    public List<InventoryDetail> findAll() {
        return inventoryDetailRepository.findAll();
    }

    @Override
    public List<InventoryDetailDTO> getAllInventoryDetails() {
        return inventoryDetailRepository.getAllInventoryDetails();
    }

    @Override
    public List<InventoryDetailDTO> getInventoryGroupByProduct() {
        return inventoryDetailRepository.getInventoryGroupByProduct();
    }

    @Override
    public Optional<InventoryDetail> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public InventoryDetail getById(Long id) {
        return null;
    }

    @Override
    public InventoryDetail save(InventoryDetail inventoryDetail) {
        return inventoryDetailRepository.save(inventoryDetail);
    }

    @Override
    public void remove(Long id) {

    }
}
