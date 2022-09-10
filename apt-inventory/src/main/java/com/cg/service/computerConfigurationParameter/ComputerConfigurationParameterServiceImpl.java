package com.cg.service.computerConfigurationParameter;

import com.cg.model.ComputerConfigurationParameter;
import com.cg.repository.ComputerConfigurationParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ComputerConfigurationParameterServiceImpl implements ComputerConfigurationParameterService {

    @Autowired
    private ComputerConfigurationParameterRepository computerConfigurationParameterRepository;

    public List<ComputerConfigurationParameter> findAll() {
        return computerConfigurationParameterRepository.findAll();
    }

    @Override
    public ComputerConfigurationParameter save(ComputerConfigurationParameter computerConfigurationParameter) {
        return computerConfigurationParameterRepository.save(computerConfigurationParameter);
    }

}
