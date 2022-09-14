package com.cg.service.situation;

import com.cg.model.Situation;
import com.cg.model.dto.InventoryDetailProductCodeDTO;
import com.cg.model.dto.OrderDTO;
import com.cg.model.dto.OrderDetailDTO;
import com.cg.model.dto.SituationDTO;

import java.util.List;
import java.util.Optional;

public interface SituationService {
    List<SituationDTO> findAllSituationDTO(String employeeId);

    List<SituationDTO> getOrderHistory(String orderId);

    Optional<SituationDTO> findLastSituationDTOByOrderIdAndEmployeeId(String employeeId, String orderId);
    void cancelledOrder(SituationDTO situationDTO,SituationDTO newSituationDTO);
    SituationDTO changeOrderDelivery(SituationDTO situationDTO, SituationDTO newSituationDTO, OrderDTO orderDTO);
    SituationDTO changeOrderPending(SituationDTO situationDTO, SituationDTO newSituationDTO, OrderDTO orderDTO, List<InventoryDetailProductCodeDTO> inventoryDetailProductCodeDTOList);

}
