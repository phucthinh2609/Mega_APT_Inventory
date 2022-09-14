package com.cg.service.situation;
import com.cg.model.InventoryDetail;
import com.cg.model.Order;
import com.cg.model.Situation;
import com.cg.model.dto.*;
import com.cg.model.enums.EInventoryDetailStatus;
import com.cg.repository.InventoryDetailRepository;
import com.cg.repository.InventoryRepository;
import com.cg.repository.OrderRepository;
import com.cg.repository.SituationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public List<SituationDTO> findAllSituationDTO(String employeeId) {
       return situationRepository.findAllSituationDTO(employeeId);
    }

    @Override
    public List<SituationDTO> getOrderHistory(String orderId) {
        return situationRepository.getOrderHistory(orderId);
    }

    @Override
    public Optional<SituationDTO> findLastSituationDTOByOrderIdAndEmployeeId(String employeeId, String orderId) {
        return situationRepository.findLastSituationDTOByOrderIdAndEmployeeId(employeeId,orderId);
    }

    @Override
    public void cancelledOrder(SituationDTO situationDTO,SituationDTO newSituationDTO,List<InventoryDetailProductCodeDTO> inventoryDetailProductCodeDTOList) {
        situationDTO.setActive(false);
        situationDTO.setEmployee(newSituationDTO.getEmployee());
        situationRepository.save(situationDTO.toSituation());
        situationRepository.save(newSituationDTO.toSituation());
        for (InventoryDetailProductCodeDTO inventoryDetailProductCodeDTO : inventoryDetailProductCodeDTOList) {
            inventoryDetailProductCodeDTO.setStatus(EInventoryDetailStatus.IN_STOCK);
            inventoryDetailRepository.save(inventoryDetailProductCodeDTO.toInventoryDetail());
        }
    }

    @Override
    public SituationDTO changeOrderDelivery(SituationDTO situationDTO, SituationDTO newSituationDTO ,OrderDTO orderDTO, List<InventoryDetailProductCodeDTO> inventoryDetailProductCodeDTOList) {
        situationDTO.setActive(false);
        situationDTO.setEmployee(newSituationDTO.getEmployee());
        Order newOrder = orderRepository.save(orderDTO.toOrder());
        situationDTO.setOrder(newOrder.toOrderDTO());
        newSituationDTO.setOrder(newOrder.toOrderDTO());
        situationRepository.save(situationDTO.toSituation());
        Situation situation = situationRepository.save(newSituationDTO.toSituation());
        for (InventoryDetailProductCodeDTO inventoryDetailProductCodeDTO : inventoryDetailProductCodeDTOList) {
            inventoryDetailProductCodeDTO.setStatus(EInventoryDetailStatus.SOLD);
            inventoryDetailRepository.save(inventoryDetailProductCodeDTO.toInventoryDetail());
        }
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
        List<InventoryDetailProductCodeDTO> list = new ArrayList<>();
        for (InventoryDetailProductCodeDTO inventoryDetailProductCodeDTO : inventoryDetailProductCodeDTOList) {
            inventoryDetailProductCodeDTO.setStatus(EInventoryDetailStatus.EXPORTED);
            InventoryDetail inventoryDetail = inventoryDetailRepository.save(inventoryDetailProductCodeDTO.toInventoryDetail());
            list.add(inventoryDetail.toInventoryDetailProductCodeDTO());
        }
        for (InventoryDetailProductCodeDTO inventoryDetailProductCodeDTO : list) {
            Optional<InventoryDTO> inventoryDTOOptional = inventoryRepository.getInventoryByProductId(inventoryDetailProductCodeDTO.getProduct().getId());
            InventoryDTO inventoryDTO = inventoryDTOOptional.get();
            inventoryDTO.setAvailable(inventoryDTO.getAvailable() - 1);
            inventoryRepository.save(inventoryDTO.toInventory());
        }
        return situation.toSituationDTO();
    }
}
