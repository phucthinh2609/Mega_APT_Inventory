package com.cg.service.orderDetail;

import com.cg.model.OrderDetail;
import com.cg.model.dto.OrderDetailDTO;
import com.cg.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Override
    public List<OrderDetailDTO> findAllOrderDetailDTO(String id) {
        return orderDetailRepository.findAllOrderDetailDTO(id);
    }

    @Override
    public List<OrderDetail> findAllByOrderId(String id) {
        return orderDetailRepository.findAllByOrderId(id);
    }
}
