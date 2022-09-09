package com.cg.model;

import com.cg.model.dto.RoleDTO;
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
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String code;
    private String name;

    @OneToMany(targetEntity = Customer.class, mappedBy = "role", fetch = FetchType.EAGER)
    private Set<Customer> customers;

    @OneToMany(targetEntity = Customer.class, mappedBy = "role", fetch = FetchType.EAGER)
    private Set<Employee> employees;

    public RoleDTO toRoleDTO() {
        return new RoleDTO()
                .setId(id)
                .setCode(code)
                .setName(name);
    }
//    @Override
//    public String toString() {
//        return "Role{" +
//                "id=" + id +
//                ", code='" + code + '\'' +
//                ", name='" + name + '\'' +
//                ", users=" + users +
//                '}';
//    }
}
