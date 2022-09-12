package com.cg.repository;

import com.cg.model.Order;
import com.cg.model.ProductMedia;
import com.cg.model.dto.OrderDTO;
import com.cg.model.dto.OrderDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    @Query("SELECT new com.cg.model.dto.OrderDTO (" +
            "o.id, " +
            "o.quantityTotal, " +
            "o.totalAmount," +
            "o.customer," +
            "o.locationRegionDelivery" +
            ") " +
            "FROM Order AS o " +
            "WHERE o.id = :id"
    )
    Optional<OrderDTO> findOrderDTOById(String id);
}
