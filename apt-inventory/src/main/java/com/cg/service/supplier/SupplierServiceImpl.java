package com.cg.service.supplier;

import com.cg.model.LocationRegion;
import com.cg.model.Supplier;
import com.cg.model.dto.SupplierDTO;
import com.cg.repository.LocationRegionRepository;
import com.cg.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private LocationRegionRepository locationRegionRepository;

    @Override
    public List<SupplierDTO> getAllSupplierDTO() {
        return supplierRepository.getAllSupplierDTO();
    }

    @Override
    public Optional<SupplierDTO> getSupplierDTOById(Long supplierId) {
        return supplierRepository.getSupplierDTOById(supplierId);
    }

    @Override
    public Optional<SupplierDTO> getSupplierDTOByEmailAndIdIsNot(String email, Long id) {
        return supplierRepository.getSupplierDTOByEmailAndIdIsNot(email, id) ;
    }

    @Override
    public Supplier create(SupplierDTO supplierDTO) {

        LocationRegion createdLocationRegion = locationRegionRepository.save(supplierDTO.getLocationRegion().toLocationRegion());

        supplierDTO.setLocationRegion(createdLocationRegion.toLocationRegionDTO());

        return supplierRepository.save(supplierDTO.toSupplier());
    }

    @Override
    public Supplier update(SupplierDTO supplierDTO) {
        LocationRegion createdLocationRegion = locationRegionRepository.save(supplierDTO.getLocationRegion().toLocationRegion());

        supplierDTO.setLocationRegion(createdLocationRegion.toLocationRegionDTO());

        return supplierRepository.save(supplierDTO.toSupplier());
    }
}
