package com.cg.service.purchaseOrder;

import com.cg.model.PurchaseOrder;
import com.cg.model.dto.PurchaseOrderDTO;
import com.cg.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService{
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public List<PurchaseOrderDTO> getAllPurchaseOrderDTO() {
        return purchaseOrderRepository.getAllPurchaseOrderDTO();
    }
}
