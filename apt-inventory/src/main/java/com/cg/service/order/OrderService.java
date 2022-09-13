package com.cg.service.order;

import com.cg.model.dto.OrderDTO;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderDTO> getAllOrders();
    Optional<OrderDTO> findOrderDTOById(String id);
}
