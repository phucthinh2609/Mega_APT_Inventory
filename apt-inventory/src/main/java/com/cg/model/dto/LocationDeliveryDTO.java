package com.cg.model.dto;

import com.cg.model.LocationDelivery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class LocationDeliveryDTO implements Validator {
    private String id;
    private String provinceId;
    private String provinceName;
    private String districtId;
    private String districtName;
    private String wardId;
    private String wardName;

    @NotBlank(message = "Vui Lòng Nhập Địa Chỉ")
    private String address;

    public LocationDelivery toLocationDelivery() {
        return new LocationDelivery()
                .setId(Long.parseLong(id))
                .setProvinceId(Long.parseLong(provinceId))
                .setProvinceName(provinceName)
                .setDistrictId(Long.parseLong(districtId))
                .setDistrictName(districtName)
                .setWardId(Long.parseLong(wardId))
                .setWardName(wardName)
                .setAddress(address);
    }



    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
