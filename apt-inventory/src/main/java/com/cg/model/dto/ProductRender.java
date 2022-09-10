package com.cg.model.dto;

import com.cg.model.ComputerConfigurationParameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductRender {
    private String id;
    private String brand;
    private String model;
    private String title;
    private String slug;
    private BigDecimal price;
    private String description;
    private Map<String, Object> configurationDetail;
    private List<ComputerConfigurationParameter> computerConfigurationParameters;
    private String businessStatus;
    private String blogId;

    private HashMap<String, String> fileUrls;
}