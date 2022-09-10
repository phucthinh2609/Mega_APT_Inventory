package com.cg.service.situation;

import com.cg.model.Situation;
import com.cg.model.dto.SituationDTO;

import java.util.List;

public interface SituationService {
    List<SituationDTO> findAllSituationDTO(String employeeId);
}
