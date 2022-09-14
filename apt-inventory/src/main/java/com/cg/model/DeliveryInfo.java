package com.cg.model;

import com.cg.model.dto.DeliveryInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Accessors(chain = true)
@Table(name = "delivery_infos")
public class DeliveryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    private String email;

    @Column(name = "full_name")
    private String fullName;

    private String phone;

    @Column(name = "province_id")
    private Long provinceId;

    @Column(name = "province_name")
    private String provinceName;

    @Column(name = "district_id")
    private Long districtId;

    @Column(name = "district_name")
    private String districtName;

    @Column(name = "ward_id")
    private Long wardId;

    @Column(name = "ward_name")
    private String wardName;

    private String address;

    @OneToOne(mappedBy = "deliveryInfo")
    private Order order;

    public DeliveryInfoDTO toDeliveryInfoDTO() {
        return new DeliveryInfoDTO()
                .setId(id.toString())
                .setCompanyName(companyName)
                .setEmail(email)
                .setFullName(fullName)
                .setPhone(phone)
                .setProvinceId(provinceId.toString())
                .setProvinceName(provinceName)
                .setDistrictId(districtId.toString())
                .setDistrictName(districtName)
                .setWardId(wardId.toString())
                .setWardName(wardName)
                .setAddress(address);
    }

}
