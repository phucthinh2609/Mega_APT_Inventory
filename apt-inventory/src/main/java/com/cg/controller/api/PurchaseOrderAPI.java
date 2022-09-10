package com.cg.controller.api;

import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Product;
import com.cg.model.PurchaseOrder;
import com.cg.model.dto.InventoryDetailDTO;
import com.cg.model.dto.PurchaseOrderDTO;
import com.cg.service.purchaseOrder.PurchaseOrderService;
import com.cg.service.purchaseOrderDetail.PurchaseOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/purchaseOrders")
public class PurchaseOrderAPI {
    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @Autowired
    private PurchaseOrderDetailService purchaseOrderDetailService;

    @GetMapping("")
    public ResponseEntity<List<?>> getAllPurchaseOrderDTO() {
        List<PurchaseOrderDTO> purchaseOrderDTOList = purchaseOrderService.getAllPurchaseOrderDTO();
        return new ResponseEntity<>(purchaseOrderDTOList, HttpStatus.OK);
    }

//    @GetMapping("/details/{purchaseOrderId}")
//    public ResponseEntity<?> getProductDetail(@PathVariable String purchaseOrderId) {
//        Optional<PurchaseOrder> optionalPurchaseOrder = purchaseOrderService.findById(purchaseOrderId);
//        if (optionalProduct.isPresent()) {
//            List<InventoryDetailDTO> inventories = inventoryDetailService.getProductDetail(productId);
//            return new ResponseEntity<>(inventories, HttpStatus.OK);
//        } else
//            throw new ResourceNotFoundException("Invalid Product ID");
//    }
}
