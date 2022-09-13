package com.cg.service.situation;
import com.cg.model.dto.SituationDTO;
import com.cg.model.enums.ESituationValue;
import com.cg.repository.SituationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SituationServiceImpl implements SituationService{

    @Autowired
    SituationRepository situationRepository;

    @Override
    public List<SituationDTO> findAllSituationDTO(String employeeId) {
       return situationRepository.findAllSituationDTO(employeeId);
    }

}
