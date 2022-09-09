package com.cg.service.situation;
import com.cg.model.dto.SituationDTO;
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
        List<SituationDTO> situationDTOList = situationRepository.findAllSituationDTO(employeeId);
        String temOrderId = situationDTOList.get(0).getOrder().getId();
        int countDelivery = 0;
        List<SituationDTO> situationDTOListRes = new ArrayList<>();
        for (int i = 0 ; i < situationDTOList.size() ; i++ ) {
            if (i == situationDTOList.size() - 1) {
                if (countDelivery == 1 || countDelivery == 0) {
                    situationDTOListRes.add(situationDTOList.get(i));
                }
            }else {
                if (temOrderId.equals(situationDTOList.get(i).getOrder().getId())) {
                    countDelivery++;
                }else {
                    if (countDelivery == 1) {
                        if (!(situationDTOList.get(i-1).getStrValue()).equals("Đã Hủy")) {
                            situationDTOListRes.add(situationDTOList.get(i-1));
                        }
                    }
                    if (countDelivery == 2) {
                        SituationDTO tempSituationDTO = situationDTOList.get(i-1);
                        String valueStatus = tempSituationDTO.getStrValue();
                        if (!(situationDTOList.get(i-1).getStrValue()).equals("Đã Hủy") || !(situationDTOList.get(i-1).getStrValue()).equals("Hoàn Thành")){
                            situationDTOListRes.add(situationDTOList.get(i-1));
                        }
                    }
                    temOrderId = situationDTOList.get(i).getOrder().getId();
                    countDelivery = 0;
                }
            }

        }
        return situationDTOListRes;
    }
}
