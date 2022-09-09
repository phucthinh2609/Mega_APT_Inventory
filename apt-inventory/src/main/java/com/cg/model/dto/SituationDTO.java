package com.cg.model.dto;

import com.cg.model.Employee;
import com.cg.model.Order;
import com.cg.model.Situation;
import com.cg.model.enums.ESituationValue;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SituationDTO implements Validator {

    private String id;
    private ESituationValue value;
    private LocalDate date;

    private OrderDTO order;

    private EmployeeDTO employee;

    public Situation toSituation() {
        return new Situation()
                .setId(id)
                .setValue(value)
                .setDate(date)
                .setOrder(order.toOrder())
                .setEmployee(employee.toEmployee());
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
