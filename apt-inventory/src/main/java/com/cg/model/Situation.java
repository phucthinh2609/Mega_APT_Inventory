package com.cg.model;

import com.cg.model.dto.SituationDTO;
import com.cg.model.enums.ESituationValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "situation")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
public class Situation {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Enumerated(EnumType.STRING)
    private ESituationValue value;

    private LocalDateTime date;

    @Column(columnDefinition = "varchar(255) default '-'")
    private String description;

    @Column(columnDefinition = "boolean default true")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public SituationDTO toSituationDTO() {
        return new SituationDTO()
                .setId(id)
                .setValue(value)
                .setDate(date)
                .setActive(active)
                .setEmployee(employee.toEmployeeDTO())
                .setDescription(description)
                .setOrder(order.toOrderDTO());
    }

}
