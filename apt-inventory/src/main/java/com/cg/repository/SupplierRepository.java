package com.cg.repository;

import com.cg.model.Supplier;
import com.cg.model.dto.SupplierDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("SELECT NEW com.cg.model.dto.SupplierDTO (" +
                "s.id, " +
                "s.companyName, " +
                "s.email, " +
                "s.phone, " +                
                "s.discount, " +
                "s.locationRegion) " +
            "FROM Supplier s ")
    List<SupplierDTO> getAllSupplierDTO();

    @Query("SELECT NEW com.cg.model.dto.SupplierDTO (" +
                "s.id, " +
                "s.companyName, " +
                "s.email, " +
                "s.phone, " +
                "s.discount, " +
                "s.locationRegion) " +
            "FROM Supplier s " +
            "WHERE s.id = ?1")
    Optional<SupplierDTO> getSupplierDTOById(Long SupplierId);

    @Query("SELECT NEW com.cg.model.dto.SupplierDTO (" +
                "s.id, " +
                "s.companyName, " +
                "s.email, " +
                "s.phone, " +
                "s.discount, " +
                "s.locationRegion) " +
            "FROM Supplier s WHERE s.email = ?1 AND s.id <> ?2 ")
    Optional<SupplierDTO> getSupplierDTOByEmailAndIdIsNot(String Email, Long id);
}
