package com.cg.service.order;

import com.cg.model.dto.OrderDTO;

import java.util.Optional;

public interface OrderService {
    Optional<OrderDTO> findOrderDTOById(String id);
}
