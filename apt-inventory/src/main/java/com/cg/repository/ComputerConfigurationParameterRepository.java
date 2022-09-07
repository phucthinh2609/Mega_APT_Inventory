package com.cg.repository;

import com.cg.model.ComputerConfigurationParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerConfigurationParameterRepository extends JpaRepository<ComputerConfigurationParameter, Long> {
}

