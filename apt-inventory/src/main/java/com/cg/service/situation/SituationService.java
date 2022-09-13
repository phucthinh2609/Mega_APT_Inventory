package com.cg.service.situation;

import com.cg.model.Situation;
import com.cg.model.dto.OrderDTO;
import com.cg.model.dto.SituationDTO;

import java.util.List;
import java.util.Optional;

public interface SituationService {
    List<SituationDTO> findAllSituationDTO(String employeeId);
    Optional<SituationDTO> findLastSituationDTOByOrderIdAndEmployeeId(String employeeId, String orderId);
    void cancelledOrder(SituationDTO situationDTO,SituationDTO newSituationDTO);
    SituationDTO changeOrder(SituationDTO situationDTO, SituationDTO newSituationDTO, OrderDTO orderDTO);
}
