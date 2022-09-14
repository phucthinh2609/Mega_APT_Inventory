package com.cg.service.inventoryDetail;

import com.cg.model.dto.InventoryDetailDTO;
import com.cg.model.dto.Statistics;
import com.cg.model.dto.InventoryDetailProductCodeDTO;
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

    @Override
    public List<InventoryDetailDTO> getAllInventoryDetails() {
        return inventoryDetailRepository.getAllInventoryDetails();
    }

    @Override
    public Optional<Statistics> getStatisticsByTime(String startTime) {
        return inventoryDetailRepository.getStatisticsByTime(startTime);
    }

    @Override
    public Optional<InventoryDetailProductCodeDTO> getInventoryDetailByProductCode(String productCode) {
        return inventoryDetailRepository.getInventoryDetailByProductCode(productCode);
    }
}
