package com.cg.service.supplier;


import com.cg.model.Supplier;
import com.cg.model.dto.ProductDTO;
import com.cg.model.dto.SupplierDTO;

import java.util.List;
import java.util.Optional;

public interface SupplierService {

    List<SupplierDTO> getAllSupplierDTO();

    Optional<SupplierDTO> getSupplierDTOById(Long supplierId);

    Optional<SupplierDTO> getSupplierDTOByEmailAndIdIsNot(String email, Long id);

    Supplier create(SupplierDTO supplierDTO);

    Supplier update(SupplierDTO supplierDTO);

}
