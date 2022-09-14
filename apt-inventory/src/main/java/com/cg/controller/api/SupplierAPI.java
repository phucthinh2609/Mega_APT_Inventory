package com.cg.controller.api;

import com.cg.exception.DataInputException;
import com.cg.model.Supplier;
import com.cg.model.dto.SupplierDTO;
import com.cg.service.locationRegion.LocationRegionService;
import com.cg.service.supplier.SupplierService;
import com.cg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierAPI {

    @Autowired
    SupplierService supplierService;

    @Autowired
    LocationRegionService locationRegionService;

    @Autowired
    AppUtils appUtils;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<SupplierDTO> supplierDTOListDTOList = supplierService.getAllSupplierDTO();
        return new ResponseEntity<>(supplierDTOListDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<SupplierDTO> supplierDTO = supplierService.getSupplierDTOById(id);

        return new ResponseEntity<>(supplierDTO.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Validated @RequestBody SupplierDTO supplierDTO, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }

        Optional<SupplierDTO> currentSupplierDTO = supplierService.getSupplierDTOByEmailAndIdIsNot(supplierDTO.getEmail(), Long.parseLong(supplierDTO.getId()));

        if (currentSupplierDTO.isPresent()) {
            throw new DataInputException("Email already exists!!!");
        }

        Supplier createdSupplier = supplierService.create(supplierDTO);

        return new ResponseEntity<>(createdSupplier.toSupplierDTO(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Validated @RequestBody SupplierDTO supplierDTO, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }

        Optional<SupplierDTO> currentSupplierDTO = supplierService.getSupplierDTOById(id);

        if (!currentSupplierDTO.isPresent()) {
            throw new DataInputException("Invalid supplier!!!");
        }

        Optional<SupplierDTO> emailExistsSupplierDTO = supplierService.getSupplierDTOByEmailAndIdIsNot(supplierDTO.getEmail(), id);

        if (emailExistsSupplierDTO.isPresent()) {
            throw new DataInputException("Email already exists!!!");
        }

        supplierDTO.setId(String.valueOf(id));

        Supplier updatedSupplier = supplierService.update(supplierDTO);

        return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
    }
}
