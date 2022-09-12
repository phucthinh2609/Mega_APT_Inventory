package com.cg.service.order;

import com.cg.model.dto.OrderDTO;
import com.cg.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository;
    @Override
    public Optional<OrderDTO> findOrderDTOById(String id) {
        return orderRepository.findOrderDTOById(id);
    }
}
