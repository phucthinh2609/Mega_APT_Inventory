package com.cg.model;

import com.cg.model.dto.LocationDeliveryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Accessors(chain = true)
@Table(name = "location_deliveries")
public class LocationDelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToOne(mappedBy = "locationRegionDelivery")
    private Order order;

    public LocationDeliveryDTO toLocationDeliveryDTO() {
        return new LocationDeliveryDTO()
                .setId(id.toString())
                .setProvinceId(provinceId.toString())
                .setProvinceName(provinceName)
                .setDistrictId(districtId.toString())
                .setDistrictName(districtName)
                .setWardId(wardId.toString())
                .setWardName(wardName)
                .setAddress(address);
    }

}
