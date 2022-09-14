package com.cg.controller.api;


import com.cg.exception.DataInputException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.OrderDetail;
import com.cg.model.dto.*;
import com.cg.model.enums.EInventoryDetailStatus;
import com.cg.model.enums.ESituationValue;
import com.cg.service.employee.EmployeeService;
import com.cg.service.inventoryDetail.InventoryDetailService;
import com.cg.service.order.OrderService;
import com.cg.service.orderDetail.OrderDetailService;

import com.cg.model.ProductMedia;
import com.cg.model.dto.OrderDTO;
import com.cg.model.dto.ProductRender;
import com.cg.model.dto.SituationDTO;
import com.cg.service.order.OrderService;

import com.cg.service.situation.SituationService;
import com.cg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/orders")
public class OrderAPI {
    @Autowired
    private OrderService orderService;

    @Autowired
    private SituationService situationService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    AppUtils appUtils;

    @Autowired
    InventoryDetailService inventoryDetailService;


    @GetMapping("/{employeeId}")
    public ResponseEntity<?> findAll(@PathVariable String employeeId) {
        try {
            List<SituationDTO> situationDTOS = situationService.findAllSituationDTO(employeeId);
            if (situationDTOS == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(situationDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/cancelled")
    public ResponseEntity<?> cancelledOrder(@Valid @RequestBody OrderChangeDTO orderChangeDTO, BindingResult bindingResult){
        new OrderChangeDTO().validate(orderChangeDTO, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return appUtils.mapErrorToResponse(bindingResult);
        }

        Optional<EmployeeDTO> employeeDTO = employeeService.findEmployeeDTOById(orderChangeDTO.getEmployeeId());
        if (!employeeDTO.isPresent()) {
            throw new ResourceNotFoundException("Người Dùng Không Tồn Tại");
        }

        Optional<SituationDTO> situationDTO = situationService.findLastSituationDTOByOrderIdAndEmployeeId(orderChangeDTO.getEmployeeId(), orderChangeDTO.getOrderId());
        if (!situationDTO.isPresent()) {
            throw new ResourceNotFoundException("Đơn Hàng Không Tồn Tại");
        }

        if (situationDTO.get().getValue().equals(ESituationValue.COMPLETE)) {
            throw new ResourceNotFoundException("Đơn Hàng Đã Hoàn Thành ! Không Thể Hủy Đơn Hàng");
        }

        if (situationDTO.get().getValue().equals(ESituationValue.CANCELLED)) {
            throw new ResourceNotFoundException("Đơn Hàng Đã Hủy Trước Đó ! Không Thể Tiếp Tục Hủy Đơn Hàng");
        }

        try{
            SituationDTO newSituationDTO = new SituationDTO();
            newSituationDTO.setDate(LocalDateTime.now());
            newSituationDTO.setEmployee(employeeDTO.get());
            newSituationDTO.setOrder(situationDTO.get().getOrder());
            newSituationDTO.setValue(ESituationValue.CANCELLED);
            newSituationDTO.setActive(true);
            newSituationDTO.setDescription(orderChangeDTO.getDescription());
            List<OrderDetailDTO> orderDetailDTOList = orderDetailService.findAllOrderDetailDTO(newSituationDTO.getOrder().getId());
            List<InventoryDetailProductCodeDTO> listProductCode = new ArrayList<>();
            for (OrderDetailDTO orderDetailDTO : orderDetailDTOList ) {
                Optional<InventoryDetailProductCodeDTO> inventoryDetailProductCodeDTO = inventoryDetailService.getInventoryDetailByProductCode(orderDetailDTO.getProductCode());
                listProductCode.add(inventoryDetailProductCodeDTO.get());
            }
            situationService.cancelledOrder(situationDTO.get(),newSituationDTO,listProductCode);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e) {
            throw new DataInputException("Liên Hệ Quản Trị Viên Hệ Thống Để Được Giải Quyết");
        }
    }

    @PostMapping("/change")
    public ResponseEntity<?> changeOrder(@Valid @RequestBody OrderChangeDTO orderChangeDTO, BindingResult bindingResult) {
        new OrderChangeDTO().validate(orderChangeDTO, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return appUtils.mapErrorToResponse(bindingResult);
        }

        Optional<EmployeeDTO> employeeDTO = employeeService.findEmployeeDTOById(orderChangeDTO.getEmployeeId());
        if (!employeeDTO.isPresent()) {
            throw new ResourceNotFoundException("Người Dùng Không Tồn Tại");
        }

        Optional<SituationDTO> situationDTO = situationService.findLastSituationDTOByOrderIdAndEmployeeId(orderChangeDTO.getEmployeeId(), orderChangeDTO.getOrderId());
        if (!situationDTO.isPresent()) {
            throw new ResourceNotFoundException("Đơn Hàng Không Tồn Tại");
        }

        if (situationDTO.get().getValue().equals(ESituationValue.COMPLETE)) {
            throw new ResourceNotFoundException("Đơn Hàng Đã Hoàn Thành ! Không Thể Thay Đổi Trạng Thái Của Đơn Hàng");
        }

        if (situationDTO.get().getValue().equals(ESituationValue.CANCELLED)) {
            throw new ResourceNotFoundException("Đơn Hàng Đã Hủy ! Không Thể Thay Đổi Trạng Thái Của Đơn Hàng");
        }

        if (situationDTO.get().getValue().equals(ESituationValue.PENDING)) {
            try{
                SituationDTO newSituationDTO = new SituationDTO();
                OrderDTO orderDTO = situationDTO.get().getOrder();
                orderDTO.setInventoryDeliveryDate(LocalDateTime.now());
                newSituationDTO.setDate(LocalDateTime.now());
                newSituationDTO.setEmployee(employeeDTO.get());
                newSituationDTO.setOrder(situationDTO.get().getOrder());
                newSituationDTO.setValue(ESituationValue.DELIVERY);
                newSituationDTO.setActive(true);
                newSituationDTO.setDescription(orderChangeDTO.getDescription());
                List<OrderDetailDTO> orderDetailDTOList = orderDetailService.findAllOrderDetailDTO(newSituationDTO.getOrder().getId());
                boolean flag = true;
                List<InventoryDetailProductCodeDTO> listProductCodeErr = new ArrayList<>();
                List<InventoryDetailProductCodeDTO> listProductCode = new ArrayList<>();
                for (OrderDetailDTO orderDetailDTO : orderDetailDTOList ) {
                    Optional<InventoryDetailProductCodeDTO> inventoryDetailProductCodeDTO = inventoryDetailService.getInventoryDetailByProductCode(orderDetailDTO.getProductCode());
                    if(inventoryDetailProductCodeDTO.get().getStatus().equals(EInventoryDetailStatus.EXPORTED)) {
                        flag = false;
                        listProductCodeErr.add(inventoryDetailProductCodeDTO.get());
                    }else {
                        listProductCode.add(inventoryDetailProductCodeDTO.get());
                    }
                }

                if (listProductCodeErr.size() > 0) {
                    Map<String,Object> result = new HashMap<>();
                    String error = "Mã Code Đã Được Xuất Kho Trước Đó";
                    result.put("error",error);
                    result.put("listErr",listProductCodeErr);
                    return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
                }
                SituationDTO situationDTOCreate = situationService.changeOrderPending(situationDTO.get(),newSituationDTO,orderDTO,listProductCode);
                return new ResponseEntity<>(situationDTOCreate,HttpStatus.CREATED);
            }catch (Exception e) {
                throw new DataInputException("Liên Hệ Quản Trị Viên Hệ Thống Để Được Giải Quyết");
            }
        }

        if (situationDTO.get().getValue().equals(ESituationValue.DELIVERY)) {
            try{
                SituationDTO newSituationDTO = new SituationDTO();
                OrderDTO orderDTO = situationDTO.get().getOrder();
                orderDTO.setDeliveryDate(LocalDateTime.now());
                newSituationDTO.setDate(LocalDateTime.now());
                newSituationDTO.setEmployee(employeeDTO.get());
                newSituationDTO.setOrder(situationDTO.get().getOrder());
                newSituationDTO.setValue(ESituationValue.COMPLETE);
                newSituationDTO.setActive(true);
                newSituationDTO.setDescription(orderChangeDTO.getDescription());
                List<OrderDetailDTO> orderDetailDTOList = orderDetailService.findAllOrderDetailDTO(newSituationDTO.getOrder().getId());
                List<InventoryDetailProductCodeDTO> listProductCode = new ArrayList<>();
                for (OrderDetailDTO orderDetailDTO : orderDetailDTOList ) {
                    Optional<InventoryDetailProductCodeDTO> inventoryDetailProductCodeDTO = inventoryDetailService.getInventoryDetailByProductCode(orderDetailDTO.getProductCode());
                    listProductCode.add(inventoryDetailProductCodeDTO.get());
                }
                SituationDTO situationDTOCreate = situationService.changeOrderDelivery(situationDTO.get(),newSituationDTO,orderDTO,listProductCode);
                return new ResponseEntity<>(situationDTOCreate,HttpStatus.CREATED);
            }catch (Exception e) {
                throw new DataInputException("Liên Hệ Quản Trị Viên Hệ Thống Để Được Giải Quyết");
            }
        }

        return null;
    }
    @GetMapping("/admin")
    public ResponseEntity<?> getAllOrders() {

            List<OrderDTO> orderDTOS = orderService.getAllOrders();
            if (orderDTOS == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orderDTOS, HttpStatus.OK);

    }

    @GetMapping("/admin/history/{orderId}")
    public ResponseEntity<?> getOrderHistory(@PathVariable String orderId) {

        List<SituationDTO> situationDTOList = situationService.getOrderHistory(orderId);
        if (situationDTOList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(situationDTOList, HttpStatus.OK);

    }
}
