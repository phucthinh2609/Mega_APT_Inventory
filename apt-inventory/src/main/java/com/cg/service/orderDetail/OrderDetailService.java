package com.cg.service.orderDetail;

import com.cg.model.OrderDetail;
import com.cg.model.dto.OrderDetailDTO;
import com.cg.model.dto.SituationDTO;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailDTO> findAllOrderDetailDTO(String id);
    List<OrderDetail> findAllByOrderId(String id);

}
