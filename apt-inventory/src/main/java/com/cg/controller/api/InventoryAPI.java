package com.cg.controller.api;

import com.cg.model.dto.InventoryDetailDTO;
import com.cg.service.inventoryDetail.InventoryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
public class InventoryAPI {

    @Autowired
    private InventoryDetailService inventoryDetailService;

    @GetMapping("")
    public ResponseEntity<?> getInventoryOverview() {

        List<InventoryDetailDTO> inventoryDetails = inventoryDetailService.getInventoryGroupByProduct();

        return new ResponseEntity<>(inventoryDetails, HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<?> getAllInventoryDetails() {

        List<InventoryDetailDTO> inventoryDetails = inventoryDetailService.getAllInventoryDetails();

        return new ResponseEntity<>(inventoryDetails, HttpStatus.OK);
    }


}
