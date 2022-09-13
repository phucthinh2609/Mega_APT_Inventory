package com.cg.model.dto;


import com.cg.model.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class EmployeeDTO implements Validator {

    private String id;
    private String email;
    private String password;
    private String fullName;
    private String phone;
    private LocationRegionDTO locationRegion;
    private RoleDTO role;
    private UserMediaDTO userMedia;

    public Employee toEmployee() {
        return new Employee()
                .setId(id)
                .setEmail(email)
                .setPassword(password)
                .setFullName(fullName)
                .setPhone(phone)
                .setLocationRegion(locationRegion.toLocationRegion())
                .setRole(role.toRole())
                .setUserMedia(userMedia.toUserMedia());
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
