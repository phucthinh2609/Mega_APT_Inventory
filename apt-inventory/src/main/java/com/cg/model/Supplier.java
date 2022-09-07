package com.cg.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Set;


@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    private String email;

    private  String phone;

    @Digits(integer = 2, fraction = 3)
    private BigDecimal discount;

    @OneToOne
    @JoinColumn(name = "location_region_id", nullable = false)
    private LocationRegion locationRegion;


}
