package com.cg.model;

import com.cg.model.dto.SupplierDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "suppliers")
@Accessors(chain = true)
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    private String email;

    private String phone;

    @Digits(integer = 2, fraction = 3)
    private BigDecimal discount;

    @OneToOne
    @JoinColumn(name = "location_region_id")
    private LocationRegion locationRegion;

    public SupplierDTO toSupplierDTO() {
        return new SupplierDTO()
                .setId(String.valueOf(id))
                .setCompanyName(companyName)
                .setEmail(email)
                .setPhone(phone)
                .setDiscount(String.valueOf(discount))
                .setLocationRegion(locationRegion.toLocationRegionDTO());
    }
}
