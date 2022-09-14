package com.cg.service.employee;

import com.cg.model.dto.EmployeeDTO;
import com.cg.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Optional<EmployeeDTO> findEmployeeDTOById(String id) {
        return employeeRepository.findEmployeeDTOById(id);
    }
}
