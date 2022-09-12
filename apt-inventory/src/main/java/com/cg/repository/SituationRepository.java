package com.cg.repository;


import com.cg.model.ProductMedia;
import com.cg.model.Situation;
import com.cg.model.dto.SituationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface SituationRepository extends JpaRepository<Situation, String> {
    @Query("SELECT new com.cg.model.dto.SituationDTO (" +
            "s.id, " +
            "s.value, " +
            "s.order" +
            ") " +
            "FROM Situation AS s " +
            "WHERE (s.employee.id = :id OR s.employee.id IS NULL) AND s.active IS TRUE AND (s.value <> 'COMPLETE' AND s.value <> 'CANCELLED') " +
            "ORDER BY s.order.id DESC "
    )
    List<SituationDTO> findAllSituationDTO(String id);
}
