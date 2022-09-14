package com.cg.model.dto;

import com.cg.model.LocationRegion;
import com.cg.model.Supplier;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class SupplierDTO {

    private String id;

    @NotBlank(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone is required")
    private String phone;

    @NotBlank(message = "Discount is required")
    private String discount;

    @Valid
    private LocationRegionDTO locationRegion;

    public SupplierDTO(Long id, String companyName, String email, String phone, BigDecimal discount, LocationRegion locationRegion) {
        this.id = String.valueOf(id);
        this.companyName = companyName;
        this.email = email;
        this.phone = phone;
        this.discount = String.valueOf(discount);
        this.locationRegion = locationRegion.toLocationRegionDTO();
    }

    public Supplier toSupplier() {
        return new Supplier()
                .setId(Long.valueOf(id))
                .setCompanyName(companyName)
                .setEmail(email)
                .setPhone(phone)
                .setDiscount(new BigDecimal(discount))
                .setLocationRegion(locationRegion.toLocationRegion());
    }
}
