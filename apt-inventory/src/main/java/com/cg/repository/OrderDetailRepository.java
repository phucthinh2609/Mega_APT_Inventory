package com.cg.repository;

import com.cg.model.OrderDetail;
import com.cg.model.dto.OrderDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    @Query("SELECT new com.cg.model.dto.OrderDetailDTO (" +
            "o.id, " +
            "o.price," +
            "o.product," +
            "o.order," +
            "o.productCode" +
            ") " +
            "FROM OrderDetail AS o " +
            "WHERE o.order.id = :id"
    )
    List<OrderDetailDTO> findAllOrderDetailDTO(String id);

    List<OrderDetail> findAllByOrderId(String id);
}
