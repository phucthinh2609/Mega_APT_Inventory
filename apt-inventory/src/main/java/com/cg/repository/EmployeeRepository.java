package com.cg.repository;

import com.cg.model.Employee;
import com.cg.model.dto.EmployeeDTO;
import com.cg.model.dto.OrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
    @Query("SELECT new com.cg.model.dto.EmployeeDTO (" +
            "e.id," +
            "e.email," +
            "e.password," +
            "e.fullName," +
            "e.phone," +
            "e.locationRegion," +
            "e.role," +
            "e.userMedia" +
            ") " +
            "FROM Employee AS e " +
            "WHERE e.id = :id"
    )
    Optional<EmployeeDTO> findEmployeeDTOById(String id);
}
