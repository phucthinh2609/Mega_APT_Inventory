package com.cg.controller.api;

import com.cg.exception.DataInputException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.OrderDetail;
import com.cg.model.dto.OrderDTO;
import com.cg.model.dto.OrderDetailDTO;
import com.cg.service.order.OrderService;
import com.cg.service.orderDetail.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order-detail")
public class OrderDetailAPI {
    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    OrderService orderService;

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getAllOrderDetail(@PathVariable String orderId) {
        Optional<OrderDTO> orderDTO = orderService.findOrderDTOById(orderId);
        if (!orderDTO.isPresent()) {
            throw new ResourceNotFoundException("Đơn Hàng Không Tồn Tại");
        }
        try{
            List<OrderDetailDTO> orderDetailDTOList = orderDetailService.findAllOrderDetailDTO(orderDTO.get().getId());
            return new ResponseEntity<>(orderDetailDTOList, HttpStatus.OK);
        }catch (DataIntegrityViolationException e) {
            throw new DataInputException("Liên Hệ Quản Trị Viên Hệ Thống Để Giải Quyết");
        }
    }
}