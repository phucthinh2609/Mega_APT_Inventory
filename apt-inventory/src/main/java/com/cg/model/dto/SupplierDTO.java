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
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class SupplierDTO {

    private String id;

    @NotBlank(message = "Company name is required")
    @Size(max = 50, message = "The length of companyName must be between 5 and 50 characters")
    private String companyName;

    @NotBlank(message = "Email is required")
    @Size(max = 50, message = "The length of email must be between 5 and 50 characters")
    private String email;

    @NotBlank(message = "Phone is required")
    @Size(max = 20, message = "The length of phone must be between 10 and 20 characters")
    private String phone;

    @NotBlank(message = "Discount is required")
    @Size(max = 5, message = "The length of discount must be between 0,01 and 100 numbers")
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
