package com.cg.model.dto;

import com.cg.model.ComputerConfigurationParameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

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
    private BigDecimal purchaseOrderPrice;
    private String description;
    private List<ComputerConfigurationParameter> computerConfigurationParameters;
    private String businessStatus;
    private String blogId;

    private HashMap<String, String> fileUrls;
}