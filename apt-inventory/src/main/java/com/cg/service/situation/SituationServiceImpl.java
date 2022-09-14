package com.cg.service.situation;
import com.cg.model.Order;
import com.cg.model.Situation;
import com.cg.model.dto.InventoryDetailProductCodeDTO;
import com.cg.model.dto.OrderDTO;
import com.cg.model.dto.OrderDetailDTO;
import com.cg.model.dto.SituationDTO;
import com.cg.model.enums.EInventoryDetailStatus;
import com.cg.repository.InventoryDetailRepository;
import com.cg.repository.OrderRepository;
import com.cg.repository.SituationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SituationServiceImpl implements SituationService{

    @Autowired
    SituationRepository situationRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    InventoryDetailRepository inventoryDetailRepository;

    @Override
    public List<SituationDTO> findAllSituationDTO(String employeeId) {
       return situationRepository.findAllSituationDTO(employeeId);
    }

    @Override
    public Optional<SituationDTO> findLastSituationDTOByOrderIdAndEmployeeId(String employeeId, String orderId) {
        return situationRepository.findLastSituationDTOByOrderIdAndEmployeeId(employeeId,orderId);
    }

    @Override
    public void cancelledOrder(SituationDTO situationDTO,SituationDTO newSituationDTO) {
        situationDTO.setActive(false);
        situationDTO.setEmployee(newSituationDTO.getEmployee());
        situationRepository.save(situationDTO.toSituation());
        situationRepository.save(newSituationDTO.toSituation());
    }

    @Override
    public SituationDTO changeOrderDelivery(SituationDTO situationDTO, SituationDTO newSituationDTO ,OrderDTO orderDTO) {
        situationDTO.setActive(false);
        situationDTO.setEmployee(newSituationDTO.getEmployee());
        Order newOrder = orderRepository.save(orderDTO.toOrder());
        situationDTO.setOrder(newOrder.toOrderDTO());
        newSituationDTO.setOrder(newOrder.toOrderDTO());
        situationRepository.save(situationDTO.toSituation());
        Situation situation = situationRepository.save(newSituationDTO.toSituation());
        return situation.toSituationDTO();
    }

    @Override
    public SituationDTO changeOrderPending(SituationDTO situationDTO, SituationDTO newSituationDTO, OrderDTO orderDTO, List<InventoryDetailProductCodeDTO> inventoryDetailProductCodeDTOList) {
        situationDTO.setActive(false);
        situationDTO.setEmployee(newSituationDTO.getEmployee());
        Order newOrder = orderRepository.save(orderDTO.toOrder());
        situationDTO.setOrder(newOrder.toOrderDTO());
        newSituationDTO.setOrder(newOrder.toOrderDTO());
        situationRepository.save(situationDTO.toSituation());
        Situation situation = situationRepository.save(newSituationDTO.toSituation());
        for (InventoryDetailProductCodeDTO inventoryDetailProductCodeDTO : inventoryDetailProductCodeDTOList) {
            inventoryDetailProductCodeDTO.setStatus(EInventoryDetailStatus.EXPORTED);
            inventoryDetailRepository.save(inventoryDetailProductCodeDTO.toInventoryDetail());
        }
        return situation.toSituationDTO();
    }
}
