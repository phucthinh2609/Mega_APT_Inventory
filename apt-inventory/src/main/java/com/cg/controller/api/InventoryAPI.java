package com.cg.controller.api;

import com.cg.model.dto.InventoryDetailDTO;
import com.cg.service.inventoryDetail.InventoryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/inventories")
public class InventoryAPI {

    @Autowired
    private InventoryDetailService inventoryDetailService;

    @GetMapping("")
    public ResponseEntity<?> getInventoryOverview() {
        List<InventoryDetailDTO> inventories = inventoryDetailService.getInventoryOverView();
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }

    @GetMapping("/totalQuantity")
    public ResponseEntity<?> getInventoryTotalQuantity() {
        int totalQuantity = inventoryDetailService.getInventoryTotalQuantity();
        return new ResponseEntity<>(totalQuantity, HttpStatus.OK);
    }

    @GetMapping("/totalAmount")
    public ResponseEntity<?> getInventoryTotalAmount() {
        BigDecimal totalAmount = inventoryDetailService.getInventoryTotalAmount();
        return new ResponseEntity<>(totalAmount, HttpStatus.OK);
    }


    @GetMapping("/brands")
    public ResponseEntity<?> getInventoryGroupByBrand() {
        List<InventoryDetailDTO> inventories = inventoryDetailService.getInventoryGroupByBrand();
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }

    @GetMapping("/models")
    public ResponseEntity<?> getInventoryGroupByModel() {
        List<InventoryDetailDTO> inventories = inventoryDetailService.getInventoryGroupByModel();
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }
//
//    @GetMapping("/cores/{core}")
//    public ResponseEntity<?> getInventoryGroupByCore(@PathVariable String core) {
//        List<InventoryDetailDTO> inventories = inventoryDetailService.getInventoryGroupByCore(core);
//        return new ResponseEntity<>(inventories, HttpStatus.OK);
//    }
//
//    @GetMapping("/rams")
//    public ResponseEntity<?> getInventoryGroupByRam() {
//        List<InventoryDetailDTO> inventories = inventoryDetailService.getInventoryGroupByRam();
//        return new ResponseEntity<>(inventories, HttpStatus.OK);
//    }
//
//    @GetMapping("/capacities")
//    public ResponseEntity<?> getInventoryGroupByCapacity() {
//        List<InventoryDetailDTO> inventories = inventoryDetailService.getInventoryGroupByCapacity();
//        return new ResponseEntity<>(inventories, HttpStatus.OK);
//    }

    @GetMapping("/details")
    public ResponseEntity<?> getAllInventoryDetails() {
        List<InventoryDetailDTO> inventories = inventoryDetailService.getAllInventoryDetails();
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }


}
