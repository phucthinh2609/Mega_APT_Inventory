package com.cg.service.employee;

import com.cg.model.dto.EmployeeDTO;

import java.util.Optional;

public interface EmployeeService {
    Optional<EmployeeDTO> findEmployeeDTOById(String id);
}
