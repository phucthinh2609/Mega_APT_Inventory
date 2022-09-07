package com.cg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String title;

    private String slug;

    private String description;

    @OneToMany(targetEntity = BlogMedia.class, mappedBy = "blog", fetch = FetchType.EAGER)
    private Set<BlogMedia> blogMedias;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
