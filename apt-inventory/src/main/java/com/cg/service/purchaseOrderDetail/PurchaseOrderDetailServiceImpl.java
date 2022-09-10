package com.cg.service.purchaseOrderDetail;

import com.cg.model.PurchaseOrdersDetail;
import com.cg.repository.PurchaseOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PurchaseOrderDetailServiceImpl implements PurchaseOrderDetailService{

    @Autowired
    private PurchaseOrderDetailRepository purchaseOrderDetailRepository;

    @Override
    public Optional<PurchaseOrdersDetail> findByPurchaseOrderId(String purchaseOrderId) {
        return purchaseOrderDetailRepository.findByPurchaseOrderId(purchaseOrderId);
    }
}
