package com.cg.model.dto;

import com.cg.model.DeliveryInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class DeliveryInfoDTO implements Validator {
    private String id;
    private String companyName;
    private String email;
    private String fullName;
    private String phone;
    private String provinceId;
    private String provinceName;
    private String districtId;
    private String districtName;
    private String wardId;
    private String wardName;

    @NotBlank(message = "Vui Lòng Nhập Địa Chỉ")
    private String address;

    public DeliveryInfo toDeliveryInfo() {
        return new DeliveryInfo()
                .setId(Long.parseLong(id))
                .setCompanyName(companyName)
                .setEmail(email)
                .setFullName(fullName)
                .setPhone(phone)
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
