package com.cg.service.inventoryDetail;

import com.cg.model.dto.InventoryDetailDTO;
import com.cg.model.dto.Statistics;
import com.cg.repository.InventoryDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InventoryDetailServiceImpl implements InventoryDetailService {

    @Autowired
    private InventoryDetailRepository inventoryDetailRepository;

    @Override
    public List<InventoryDetailDTO> getProductDetail(String productId) {
        return inventoryDetailRepository.getProductDetail(productId);
    }

    @Override
    public int getInventoryTotalQuantity() {
        return inventoryDetailRepository.getInventoryTotalQuantity();
    }

    @Override
    public BigDecimal getInventoryTotalAmount() {
        return inventoryDetailRepository.getInventoryTotalAmount();
    }

//    @Override
//    public int getQuantityOfGroup(String group) {
//        return inventoryDetailRepository.getQuantityOfGroup(group);
//    }

//    @Override
//    public List<InventoryDetailDTO> getInventoryGroupByBrand() {
//        return inventoryDetailRepository.getInventoryGroupByBrand();
//    }
//
//    @Override
//    public List<InventoryDetailDTO> getInventoryGroupByModel() {
//        return inventoryDetailRepository.getInventoryGroupByModel();
//    }
//
//    @Override
//    public List<InventoryDetailDTO> getInventoryGroupByCore(String core) {
//        return inventoryDetailRepository.getInventoryGroupByCore(core);
//    }
//
//    @Override
//    public List<InventoryDetailDTO> getInventoryGroupByRam() {
//        return inventoryDetailRepository.getInventoryGroupByRam();
//    }
//
//    @Override
//    public List<InventoryDetailDTO> getInventoryGroupByCapacity() {
//        return inventoryDetailRepository.getInventoryGroupByCapacity();
//    }

    @Override
    public List<InventoryDetailDTO> getAllInventoryDetails() {
        return inventoryDetailRepository.getAllInventoryDetails();
    }

    @Override
    public Optional<Statistics> getStatisticsByTime(String startTime) {
        return inventoryDetailRepository.getStatisticsByTime(startTime);
    }
}
