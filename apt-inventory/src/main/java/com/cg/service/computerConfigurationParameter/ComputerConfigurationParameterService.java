package com.cg.service.computerConfigurationParameter;

import com.cg.model.ComputerConfigurationParameter;

import java.util.List;

public interface ComputerConfigurationParameterService {
    List<ComputerConfigurationParameter> findAll();

    ComputerConfigurationParameter save(ComputerConfigurationParameter computerConfigurationParameter);
}
