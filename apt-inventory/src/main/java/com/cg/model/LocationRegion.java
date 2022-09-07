package com.cg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "location_regions")
@Accessors(chain = true)
public class LocationRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    @OneToOne(mappedBy = "locationRegion")
    private Customer customer;

    @OneToOne(mappedBy = "locationRegion")
    private Employee employee;

//    public LocationRegionDTO toLocationRegionDTO() {
//        return new LocationRegionDTO()
//                .setId(id)
//                .setProvinceId(provinceId)
//                .setProvinceName(provinceName)
//                .setDistrictId(districtId)
//                .setDistrictName(districtName)
//                .setWardId(wardId)
//                .setWardName(wardName)
//                .setAddress(address);
//    }

}