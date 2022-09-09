package com.cg.controller.api;

import com.cg.model.ProductMedia;
import com.cg.model.dto.ProductRender;
import com.cg.model.dto.SituationDTO;
import com.cg.service.situation.SituationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderAPI {
    @Autowired
    SituationService situationService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        try {
            List<SituationDTO> situationDTOS = situationService.findAllSituationDTO("1");
            if (situationDTOS == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(situationDTOS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
